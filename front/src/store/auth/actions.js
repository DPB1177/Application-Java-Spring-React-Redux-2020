export const AUTH_CHANGE_URL_TEXT = "AUTH_CHANGE_URL_TEXT";
export const AUTH_CHANGE_LOGIN_TEXT = "AUTH_CHANGE_LOGIN_TEXT";
export const AUTH_CHANGE_PASSWORD_TEXT = "AUTH_CHANGE_PASSWORD_TEXT";
export const AUTH_CONNECT_DB = "AUTH_CONNECT_DB";
export const AUTH_SET_ZERO_NODE = "AUTH_SET_ZERO_NODE";

export const setUrlText = (url) => ({
    type: AUTH_CHANGE_URL_TEXT,
    payload: url
});

export const setLoginText = (user) => ({
    type: AUTH_CHANGE_LOGIN_TEXT,
    payload: user
});

export const setPassWordText = (password) => ({
    type: AUTH_CHANGE_PASSWORD_TEXT,
    payload: password
});

export const connectDB = (connect_variable) => ({
    type: AUTH_CONNECT_DB,
    payload: connect_variable
});

export const setZeroNode = (variable) => ({
    type: AUTH_SET_ZERO_NODE,
    payload: variable
});