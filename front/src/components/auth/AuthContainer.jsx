import React from "react";
import Auth from "./Auth";
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import {connectDB, setLoginText, setPassWordText, setUrlText, setZeroNode} from "../../store/auth/actions";

class AuthContainer extends React.Component {
    render() {
        return (
            <Auth
                user={this.props.user}
                password={this.props.password}
                url={this.props.url}
                port={this.props.port}
                hide_={this.props.hide_}
                connect_variable={this.props.connect_variable}

                setUrlText={this.props.setUrlText}
                setLoginText={this.props.setLoginText}
                setPassWordText={this.props.setPassWordText}
                connectDB={this.props.connectDB}
                setZeroNode={this.props.setZeroNode}
            />
        );
    }
}

const mapStateProps = (state) => {
    return {
        user: state.auth.user,
        password: state.auth.password,
        url: state.auth.url,
        port: state.auth.port,
        connect_variable: state.auth.connect_variable,
        hide_: state.auth.hide_,
    };
};

const mapDispatchToProp = (dispatch) => {
    return {
        setUrlText: bindActionCreators(setUrlText, dispatch),
        setLoginText: bindActionCreators(setLoginText, dispatch),
        setPassWordText: bindActionCreators(setPassWordText, dispatch),
        connectDB: bindActionCreators(connectDB, dispatch),
        setZeroNode: bindActionCreators(setZeroNode, dispatch),
    };
};

export default connect(mapStateProps, mapDispatchToProp)(AuthContainer);