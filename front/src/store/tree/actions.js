export const TREE_CHANGE_FLAG = "TREE_CHANGE_FLAG";
export const TREE_CHANGE_TREE = "TREE_CHANGE_TREE";
export const ONE_SET_DATA = "ONE_SET_DATA";
export const ONE_SET_TREE = "ONE_SET_TREE";
export const TABLE_SET_DATA = "TABLE_SET_DATA";

export const SET_INDEX_WAS_ONE_CLICK = "SET_INDEX_WAS_ONE_CLICK";
export const SET_INDEX_MINUS = "SET_INDEX_MINUS";
export const SET_INDEX_PLUS = "SET_INDEX_PLUS";
export const SET_INDEX_ZERO = "SET_INDEX_ZERO";

export const SET_STRING_XML = "SET_STRING_XML";

export const SET_INDEX_WAS_ONE_CLICK_XML = "SET_INDEX_WAS_ONE_CLICK_XML";
export const SET_INDEX_MINUS_XML = "SET_INDEX_MINUS_XML";
export const SET_INDEX_PLUS_XML = "SET_INDEX_PLUS_XML";
export const SET_INDEX_ZERO_XML = "SET_INDEX_ZERO_XML";

export const SET_INDEX_LOAD_NODE = "SET_INDEX_LOAD_NODE";
export const SET_INDEX_VISIBLE_CHILDREN_XML = "SET_INDEX_VISIBLE_CHILDREN_XML";
export const SET_INDEX_LOAD_NODE_XML = "SET_INDEX_LOAD_NODE_XML";
export const SET_INDEX_VISIBLE_CHILDREN = "SET_INDEX_VISIBLE_CHILDREN";


export const setFlag = (flag) => ({
    type: TREE_CHANGE_FLAG,
    payload: flag
});

export const setTree = (tree) => ({
    type: TREE_CHANGE_TREE,
    payload: tree
});

export const setDataTable = (dataTable) => ({
    type: TABLE_SET_DATA,
    payload: dataTable
});

export const setIndexWasOneClick = (array) => ({
    type: SET_INDEX_WAS_ONE_CLICK,
    payload: array
});

export const setIndexMinus = (massiv) => ({
    type: SET_INDEX_MINUS,
    payload: massiv
});

export const setIndexPlus = (massiv) => ({
    type: SET_INDEX_PLUS,
    payload: massiv
});

export const setIndexZero = (massiv) => ({
    type: SET_INDEX_ZERO,
    payload: massiv
});

export const setIndexVisibleChildren = (massiv) => ({
    type: SET_INDEX_VISIBLE_CHILDREN,
    payload: massiv
});

export const setIndexLoadNode = (massiv) => ({
    type: SET_INDEX_LOAD_NODE,
    payload: massiv
});

