import React from "react";
import {connect} from "react-redux";
import SimpleTable from "./SimpleTable";

class SimpleTableContainer extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                {(String(this.props.flag) === String("error").valueOf()) ? 'Error: File did not find!' :
                    <SimpleTable object_of_table={this.props.object_of_table}/>
                }
                <br/>
                <div> {this.props.stringXML}</div>
            </div>
        );
    }
}

const mapStateProps = (state) => {
    return {
        object_of_table: state.tree.object_of_table,
        stringXML: state.tree.stringXML,
        flag: state.tree.flag,
    };
};

export default connect(mapStateProps)(SimpleTableContainer);