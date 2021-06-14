import React from "react";

import {createStore} from 'redux';
import {Provider} from 'react-redux'
import {Router, Route} from 'react-router-dom';

import {history} from "../components/history";
import Basic from "./modes/Basic";
import rootReducer from "../store/reducers"
import AuthContainer from "./auth/AuthContainer";
import OfflineMode from "./modes/OfflineMode";

export const store = createStore(rootReducer);

export default class App extends React.Component {
    render() {
        return (
            <Provider store={store}>
                <Router history={history}>
                    <Route exact path="/" component={AuthContainer}/>
                    <Route path="/tree_node" component={Basic}/>
                    <Route path="/offline_mode" component={OfflineMode}/>
                </Router>
            </Provider>
        );
    }
}
