import React from "react";
import SimpleTableContainer from "../table/SimpleTableContainer";
import {store} from "../App"
import {
    ONE_SET_DATA,
    ONE_SET_TREE,
    SET_INDEX_MINUS_XML,
    SET_INDEX_PLUS_XML,
    SET_INDEX_WAS_ONE_CLICK_XML,
    SET_INDEX_ZERO_XML,
    SET_STRING_XML, TREE_CHANGE_FLAG
} from "../../store/tree/actions";
import {history} from "../history";
import {connect} from "react-redux";
import NodeViewsContainerForOfflineMode from "../nodes/NodeViewsContainerForOfflineMode";

class OfflineMode extends React.Component {
    constructor(props) {
        super(props);
        this.state = {stringXML: ""};
        this.handleBack = this.handleBack.bind(this);
    }

    handleBack() {
        console.log("OfflineMode: handleConnectOfflineMode(): index_zero");
        console.log(this.props.index_zero);

        fetch('http://localhost:8080/backOfflineMode', {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({id: "-2"})
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
                console.log('OfflineMode: responseBody:');
                console.log(responseBody);
                return responseBody;
            })
            // .then(responseBody => {
            //     // const {connectDB} = this.props;
            //     // connectDB(responseBody.parameterConnection);
            //     return (responseBody);
            // })
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
            .then(responseBody => {
                store.dispatch({
                    type: TREE_CHANGE_FLAG,
                    payload: {
                        flag: "ok",
                    }
                });
                return (responseBody);
            })
            .then(() => {
                history.push("/tree_node");
            })

            .catch((error) => {
                console.log("Request failed", error);
            });

    }

    render() {
        return (
            <React.Fragment>
                <button className="button-for-node-page" onClick={this.handleBack}>Back</button>
                <div id="content-div">
                    <div className="grid">
                        <div className="overflow-row1"><NodeViewsContainerForOfflineMode/></div>
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
        index_was_one_click: state.tree.index_was_one_click,
        index_minus: state.tree.index_minus,
        index_plus: state.tree.index_plus,
        index_zero: state.tree.index_zero,
        flag: state.auth.flag
    };
};

export default connect(mapStateProps)(OfflineMode);