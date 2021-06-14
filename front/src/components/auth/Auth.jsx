import React from "react";
import ReactModal from 'react-modal';
import {history} from "../history";
import {store} from "../App"
import {
    ONE_SET_DATA,
    ONE_SET_TREE,
    SET_INDEX_MINUS_XML,
    SET_INDEX_PLUS_XML,
    SET_INDEX_WAS_ONE_CLICK_XML,
    SET_INDEX_ZERO_XML
} from "../../store/tree/actions";

export default class Auth extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            showModal: false,
            text: ""
        };
        this.onUrlChange = this.onUrlChange.bind(this);
        this.onUserChange = this.onUserChange.bind(this);
        this.onPassWordChange = this.onPassWordChange.bind(this);
        this.onClickButton = this.onClickButton.bind(this);

        // modal windows
        this.handleOpenModal = this.handleOpenModal.bind(this);
        this.handleCloseModal = this.handleCloseModal.bind(this);
    }

    handleOpenModal(text) {
        this.setState({showModal: true});
        this.setState({text: text});
    }

    handleCloseModal() {
        this.setState({showModal: false});
    }

    onClickButton() {
        this.props.connect_variable.user = this.props.user;
        this.props.connect_variable.password = this.props.password;
        this.props.connect_variable.url = this.props.url;
        fetch('http://localhost:8080/parameters', {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(this.props.connect_variable)
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
                console.log(responseBody);
                return responseBody;
            })
            .then(responseBody => {
                const {connectDB} = this.props;
                connectDB(responseBody.parameterConnection);
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
                history.push("/tree_node");
            })
            .catch((error) => {
                this.handleOpenModal(error.toString());
            });
    };

    onUrlChange(event) {
        this.props.setUrlText(event.target.value)
    }

    onUserChange(event) {
        this.props.setLoginText(event.target.value)
    }

    onPassWordChange(event) {
        this.props.setPassWordText(event.target.value)
    }

    render() {
        return (
            <div className="form-style-5">
                <form>
                    <fieldset>
                        <legend> URL:</legend>
                        <input type="text"
                               name="url"
                               autoComplete="off"
                               spellCheck={false}
                               value={this.props.url}
                               onChange={this.onUrlChange}
                        />
                        <legend> Login:</legend>
                        <input type="text"
                               name="login"
                               autoComplete="off"
                               spellCheck={false}
                               value={this.props.user}
                               onChange={this.onUserChange}
                        />
                        <legend> Password:</legend>
                        <input type="password"
                               name="password"
                               autoComplete="off"
                               placeholder="Password"
                               value={this.props.password}
                               onChange={this.onPassWordChange}
                        />
                    </fieldset>
                </form>
                <div>
                    <button className="button-login" onClick={this.onClickButton}>Connect</button>
                </div>
                <ReactModal
                    contentLabel="onRequestClose Example"
                    onRequestClose={this.handleCloseModal}
                    className="Modal"
                    isOpen={this.state.showModal}
                >
                    <p>{this.state.text}</p>
                    <button className="button-login" onClick={this.handleCloseModal}>Close Modal</button>
                </ReactModal>
            </div>
        );
    }
}