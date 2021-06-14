import {
    AUTH_CHANGE_LOGIN_TEXT,
    AUTH_CHANGE_PASSWORD_TEXT,
    AUTH_CHANGE_URL_TEXT,
    AUTH_CONNECT_DB,
    AUTH_SET_ZERO_NODE
} from "./actions";

const defaultState = {
    user: 'root',
    password: 'root',
    url: 'jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true',
    port: '',
    connect_variable: {user: 'testUser', password: 'testPassword', url: 'testUrl', port: 'testPort'},
    hide_: '0000000',
};


export const authReducer = (state = defaultState, action) => {
    switch (action.type) {
        case AUTH_CHANGE_URL_TEXT:
            return {
                ...state,
                url: action.payload,

            };
        case AUTH_CHANGE_LOGIN_TEXT:
            return {
                ...state,
                user: action.payload,

            };
        case AUTH_CHANGE_PASSWORD_TEXT:
            return {
                ...state,
                password: action.payload,
            };
        case AUTH_CONNECT_DB:
            // console.log("authReducer:AUTH_CONNECT_DB:action.payload");
            // console.log(action.payload);
            // console.log("state:");
            // console.log(state);
            //let ob = {parameters: {}, treeNode: {}};
            // let user = { parameters: action.payload.parameterConnection, isAdmin: false };
            // let ob = Object.assign({}, action.payload.parameterConnection, action.payload.treeNode);
//            return Object.assign({}, state.auth.connect_variable, {connect_variable: action.payload});
            return {
                ...state,
                connect_variable: action.payload,
            };


            // let connect_variable_ = {user: 'root', password: 'root', url: 'jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true', port: ''};
            // fetch('http://localhost:8080/parameters', {
            //     method: "POST",
            //     headers: {
            //         'Accept': 'application/json',
            //         'Content-Type': 'application/json',
            //     },
            //     body: JSON.stringify(connect_variable_)
            // })
            //     .then(function(response) {
            //         if(response.ok){
            //             return response.json();
            //         }{
            //             throw new Error("Post Failed")
            //         }
            //     }).then(function(responseBody){
            //     console.log(responseBody);
            //     return Object.assign({}, state, {
            //         connect_variable: responseBody
            //     })
            // })
            //     .catch(function(error) {
            //         console.log("Request failed", error);
            //     });



            // return Object.assign({}, state, {
            //     connect_variable: action.payload
            // });

        case AUTH_SET_ZERO_NODE:

            // console.log("authReducer:AUTH_CONNECT_DB:action.payload");
            // console.log(action.payload);
            // console.log("state:");
            // console.log(state);


            //let ob = {parameters: {}, treeNode: {}};
            // let user = { parameters: action.payload.parameterConnection, isAdmin: false };
            // let ob = Object.assign({}, action.payload.parameterConnection, action.payload.treeNode);
//            return Object.assign({}, state.auth.connect_variable, {connect_variable: action.payload});
            //return Object.assign({}, state.tree.object_of_tree, {object_of_tree: action.payload});


    }
    return state;
};