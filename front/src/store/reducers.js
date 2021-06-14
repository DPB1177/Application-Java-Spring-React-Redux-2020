import {combineReducers} from "redux";
import {treeReducer} from "./tree/reducer";
import {authReducer} from "./auth/reducers";

export default combineReducers({
    tree: treeReducer, auth: authReducer,
});