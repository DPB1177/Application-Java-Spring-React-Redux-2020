import React from "react";
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import NodeViewsForOfflineMode from "./NodeViewsForOfflineMode";
import {
    setFlag,
    setTree,
    setDataTable,
    setIndexWasOneClick,
    setIndexPlus,
    setIndexMinus,
    setIndexZero,
} from "../../store/tree/actions";

class NodeViewsContainerForOfflineMode extends React.Component {

    render() {
        return (
            <div>
                {(String(this.props.flag) === String("error").valueOf()) ? '' :
                    <NodeViewsForOfflineMode
                        object_of_tree={this.props.object_of_tree}
                        object_of_table={this.props.object_of_table}

                        index_was_one_click={this.props.index_was_one_click}
                        index_minus={this.props.index_minus}
                        index_plus={this.props.index_plus}
                        index_zero={this.props.index_zero}

                        flag={this.props.flag}

                        setFlag={this.props.setFlag}
                        setTree={this.props.setTree}
                        setDataTable={this.props.setDataTable}
                        setIndexWasOneClick={this.props.setIndexWasOneClick}
                        setIndexMinus={this.props.setIndexMinus}
                        setIndexPlus={this.props.setIndexPlus}
                        setIndexZero={this.props.setIndexZero}
                    />}
            </div>
        );
    }
}

const mapStateProps = (state) => {
    return {
        object_of_tree: state.tree.object_of_tree,
        object_of_table: state.tree.object_of_table,
        flag: state.tree.flag,
        index_was_one_click: state.tree.index_was_one_click,
        index_minus: state.tree.index_minus,
        index_plus: state.tree.index_plus,
        index_zero: state.tree.index_zero,

    };
};

const mapDispatchToProp = (dispatch) => {
    return {
        setFlag: bindActionCreators(setFlag, dispatch),
        setTree: bindActionCreators(setTree, dispatch),
        setDataTable: bindActionCreators(setDataTable, dispatch),
        setIndexWasOneClick: bindActionCreators(setIndexWasOneClick, dispatch),
        setIndexMinus: bindActionCreators(setIndexMinus, dispatch),
        setIndexPlus: bindActionCreators(setIndexPlus, dispatch),
        setIndexZero: bindActionCreators(setIndexZero, dispatch),
    };
};
export default connect(mapStateProps, mapDispatchToProp)(NodeViewsContainerForOfflineMode);