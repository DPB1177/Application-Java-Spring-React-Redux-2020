import React from "react";
import NodeViewsContainer from "../nodes/NodeViewsContainer";
import SimpleTableContainer from "../table/SimpleTableContainer";
import {store} from "../App"
import {
    ONE_SET_DATA,
    ONE_SET_TREE, SET_INDEX_LOAD_NODE_XML,
    SET_INDEX_MINUS_XML, SET_INDEX_PLUS_XML, SET_INDEX_VISIBLE_CHILDREN_XML, SET_INDEX_WAS_ONE_CLICK_XML,
    SET_INDEX_ZERO_XML,
    SET_STRING_XML, TREE_CHANGE_FLAG
} from "../../store/tree/actions";
import {history} from "../history";
import {connect} from "react-redux";


class Basic extends React.Component {
    constructor(props) {
        super(props);
        this.state = {stringXML: ""};
        this.handleXMLSave = this.handleXMLSave.bind(this);
        this.handleXMLLoad = this.handleXMLLoad.bind(this);
        this.handleConnectOfflineMode = this.handleConnectOfflineMode.bind(this);
    }

    handleConnectOfflineMode() {
        console.log("Basic: handleConnectOfflineMode(): index_zero");
        console.log(this.props.index_zero);
        fetch('http://localhost:8080/offlineMode', {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                user: this.props.user,
                password: this.props.password,
                url: this.props.url,
                port: this.props.port,

                index_was_one_click: this.props.index_was_one_click,
                index_minus: this.props.index_minus,
                index_plus: this.props.index_plus,
                index_zero: this.props.index_zero
            })
        })
            .then(function (response) {
                if (response.ok) {
                    return response.json();
                }
                {
                    throw new Error("Post Failed")
                }
            }).then(function (responseBody) {
            console.log('Basic.handleConnectOfflineMode(): responseBody:');
            console.log(responseBody);
            if (responseBody.parameterConnection === null) {
                    responseBody = {
                        parameterConnection: {
                            user: 'root',
                            password: 'root',
                            url: 'jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true',
                            port: 'error'
                        },
                        treeNode: {
                            "children": [],
                            "data": {"map": {"id": "0"}}
                        },
                        index_was_one_click: [],
                        index_minus: [],
                        index_plus: [],
                        index_zero: []
                    }
            }
            return responseBody;
        })
            .then(responseBody => {
                store.dispatch({
                    type: TREE_CHANGE_FLAG,
                    payload: {
                        flag: responseBody.parameterConnection.port,
                    }
                });
                return (responseBody);
            })
            .then(responseBody => {
                store.dispatch({
                    type: ONE_SET_DATA,
                    payload: {
                        treeNode: responseBody.treeNode,
                    }
                });
                return (responseBody);
            })
            .then(responseBody => {
                store.dispatch({
                    type: ONE_SET_TREE,
                    payload: {
                        object_of_tree: responseBody.treeNode,
                    }
                });
                return (responseBody);
            })
            .then(responseBody => {
                store.dispatch({
                    type: SET_STRING_XML,
                    payload: {
                        stringXML: {string: ""},
                    }
                });
                return (responseBody);
            })
            .then(responseBody => {
                store.dispatch({
                    type: SET_INDEX_WAS_ONE_CLICK_XML,
                    payload: {
                        index_was_one_click: responseBody.index_was_one_click,
                    },
                });
                return (responseBody);
            })
            .then(responseBody => {
                store.dispatch({
                    type: SET_INDEX_MINUS_XML,
                    payload: {
                        index_minus: responseBody.index_minus,
                    },
                });
                return (responseBody);
            })
            .then(responseBody => {
                store.dispatch({
                    type: SET_INDEX_PLUS_XML,
                    payload: {
                        index_plus: responseBody.index_plus,
                    },
                });
                return (responseBody);
            })

            .then(responseBody => {
                store.dispatch({
                    type: SET_INDEX_ZERO_XML,
                    payload: {
                        index_zero: responseBody.index_zero,
                    }
                });
                return (responseBody);
            })
            .then(() => {
                history.push("/offline_mode");
            })
            .catch((error) => {
                console.log("Request failed", error);
            });

    }

    handleXMLSave() {
        fetch('http://localhost:8080/saveXML', {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                index_was_one_click: this.props.index_was_one_click,
                index_minus: this.props.index_minus,
                index_plus: this.props.index_plus,
                index_zero: this.props.index_zero
            })
        })
            .then(function (response) {
                if (response.ok) {
                    return response.json();
                }
                {
                    throw new Error("Post Failed")
                }
            }).then(function (responseBody) {
            console.log('responseBody:');
            console.log(responseBody);
            return responseBody;
        })
            .then(responseBody => {
                store.dispatch({
                    type: SET_STRING_XML,
                    payload: {
                        stringXML: responseBody,
                    }
                });
            }).catch((error) => {
            console.log("Request failed", error);
        });
    }

    handleXMLLoad() {
        fetch('http://localhost:8080/loadXML', {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({index_minus: "0"})
        })
            .then(function (response) {
                if (response.ok) {
                    return response.json();
                }
                {
                    throw new Error("Post Failed")
                }
            })
            .then(function (responseBody) {
                console.log('handleXMLLoad(): responseBody:');
                console.log(responseBody);
                return responseBody;
            })
            .then(responseBody => {
                // const {connectDB} = this.props;
                // connectDB(responseBody.parameterConnection);
                return (responseBody);
            })
            .then(responseBody => {
                store.dispatch({
                    type: ONE_SET_DATA,
                    payload: {
                        treeNode: responseBody.treeNode,
                    }
                });
                return (responseBody);
            })
            .then(responseBody => {
                store.dispatch({
                    type: ONE_SET_TREE,
                    payload: {
                        object_of_tree: responseBody.treeNode,
                    }
                });
                return (responseBody);
            })
            .then(responseBody => {
                store.dispatch({
                    type: SET_STRING_XML,
                    payload: {
                        stringXML: {string: "Load XML"},
                    }
                });
                return (responseBody);
            })
            .then(responseBody => {
                store.dispatch({
                    type: SET_INDEX_WAS_ONE_CLICK_XML,
                    payload: {
                        index_was_one_click: responseBody.index_was_one_click,
                    },
                });
                return (responseBody);
            })
            .then(responseBody => {
                store.dispatch({
                    type: SET_INDEX_MINUS_XML,
                    payload: {
                        index_minus: responseBody.index_minus,
                    },
                });
                return (responseBody);
            })
            .then(responseBody => {
                store.dispatch({
                    type: SET_INDEX_PLUS_XML,
                    payload: {
                        index_plus: responseBody.index_plus,
                    },
                });
                return (responseBody);
            })

            .then(responseBody => {
                store.dispatch({
                    type: SET_INDEX_ZERO_XML,
                    payload: {
                        index_zero: responseBody.index_zero,
                    }
                });
                return (responseBody);
            })
            .catch((error) => {
                console.log("Request failed", error);
            });
    }

    render() {
        console.log(this.props.object_of_tree);
        console.log(this.props.index_zero);

        return (
            <React.Fragment>
                <button className="button-for-node-page" onClick={this.handleXMLSave}>Save XML-file</button>
                <button className="button-for-node-page" onClick={this.handleXMLLoad}>Load XML-file</button>
                <button className="button-for-node-page" onClick={this.handleConnectOfflineMode}>Connect offline
                </button>
                <div id="content-div">
                    <div className="grid">
                        <div className="overflow-row1"><NodeViewsContainer/></div>
                        <div className="row2">
                            <SimpleTableContainer/>
                        </div>
                    </div>
                </div>
            </React.Fragment>
        );
    }
}

const mapStateProps = (state) => {
    return {
        object_of_tree: state.tree.object_of_tree,
        object_of_table: state.tree.object_of_table,

        index_was_one_click: state.tree.index_was_one_click,
        index_minus: state.tree.index_minus,
        index_plus: state.tree.index_plus,
        index_zero: state.tree.index_zero,

        index_visible_children: state.tree.index_visible_children,
        index_load_node: state.tree.index_load_node,

        user: state.auth.user,
        password: state.auth.password,
        url: state.auth.url,
        port: state.auth.port,

    };
};

export default connect(mapStateProps)(Basic);