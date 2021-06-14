import {
    ONE_SET_DATA, ONE_SET_TREE,
    SET_INDEX_WAS_ONE_CLICK, SET_INDEX_MINUS, SET_INDEX_PLUS, SET_INDEX_ZERO,
    SET_INDEX_WAS_ONE_CLICK_XML, SET_INDEX_MINUS_XML, SET_INDEX_PLUS_XML, SET_INDEX_ZERO_XML,
    SET_STRING_XML,


    SET_INDEX_VISIBLE_CHILDREN_XML,
    SET_INDEX_LOAD_NODE,
    TABLE_SET_DATA,
    SET_INDEX_VISIBLE_CHILDREN,
    SET_INDEX_LOAD_NODE_XML,
    TREE_CHANGE_FLAG,
    TREE_CHANGE_TREE
} from "./actions";
import fillToTable from "../../functions/fillToTable";
import readerOneLoader from "../../functions/readerOneLoad";
import getStringXML from "../../functions/getStringXML";
import getArray from "../../functions/getArray";

const defaultState = {
    flag: "text_flag",
    object_of_tree: {
        "children": [],
        "data": {"map": {"id": "0"}}
    },
    object_of_table: {
        data: [{
            name: '',
            age: ''
        }], columns: [{
            Header: '',
            accessor: 'name'
        }, {
            Header: '',
            accessor: 'age'
        }]
    },
    index_was_one_click: [],
    index_minus: [],
    index_plus: [],
    index_zero: [],

    index_visible_children: [],
    index_load_node: [],

    stringXML: "",
};

export const treeReducer = (state = defaultState, action) => {
    switch (action.type) {
        case TREE_CHANGE_FLAG:
            return {
                ...state,
                flag: action.payload.flag,
            };
        case TREE_CHANGE_TREE:
            return {
                ...state,
                object_of_tree: action.payload,
            };
        case TABLE_SET_DATA:
            return {
                ...state,
                object_of_table: action.payload,

            };
        case ONE_SET_DATA:
            return {
                ...state,
                object_of_table: fillToTable(action.payload.treeNode.data.map),
            };
        case ONE_SET_TREE:
            return {
                ...state,
                object_of_tree: readerOneLoader(action.payload),
            };
        // -------------------------------------------------------------------------------------------------------------
        case SET_INDEX_WAS_ONE_CLICK:
            return {
                ...state,
                index_was_one_click: action.payload,
            };
        case SET_INDEX_MINUS:
            return {
                ...state,
                index_minus: action.payload,
            };
        case SET_INDEX_PLUS:
            return {
                ...state,
                index_plus: action.payload,
            };
        case SET_INDEX_ZERO:
            return {
                ...state,
                index_zero: action.payload,
            };
        // -------------------------------------------------------------------------------------------------------------
        case SET_STRING_XML:
            return {
                ...state,
                stringXML: getStringXML(action.payload),
            };
        // -------------------------------------------------------------------------------------------------------------
        case SET_INDEX_VISIBLE_CHILDREN:
            return {
                ...state,
                index_visible_children: action.payload,
            };
        case SET_INDEX_LOAD_NODE:
            return {
                ...state,
                index_load_node: action.payload,
            };
        // case SET_INDEX_MINUS_XML:
        //     return {
        //         ...state,
        //         index_minus: getArray(action.payload),
        //     };
        // case SET_INDEX_ZERO_XML:
        //     return {
        //         ...state,
        //         index_zero: getArray(action.payload),
        //     };
        // case SET_INDEX_VISIBLE_CHILDREN_XML:
        //     return {
        //         ...state,
        //         index_visible_children: getArray(action.payload),
        //     };
        // case SET_INDEX_LOAD_NODE_XML:
        //     return {
        //         ...state,
        //         index_load_node: getArray(action.payload),
        //     };
        // -------------------------------------------------------------------------------------------------------------
        case SET_INDEX_WAS_ONE_CLICK_XML:
            return {
                ...state,
                index_was_one_click: action.payload.index_was_one_click,
            };
        case SET_INDEX_MINUS_XML:
            return {
                ...state,
                index_minus: action.payload.index_minus,
            };
        case SET_INDEX_PLUS_XML:
            return {
                ...state,
                index_plus: action.payload.index_plus,
            };
        case SET_INDEX_ZERO_XML:
            return {
                ...state,
                index_zero: action.payload.index_zero,
            };
        // -------------------------------------------------------------------------------------------------------------
        case SET_INDEX_VISIBLE_CHILDREN_XML:
            return {
                ...state,
                index_visible_children: action.payload.index_visible_children,
            };
        case SET_INDEX_LOAD_NODE_XML:
            return {
                ...state,
                index_load_node: action.payload.index_load_node,
            };

    }
    return state;
};
