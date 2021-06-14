import React from "react";
import ReactTable from 'react-table';
import "react-table/react-table.css";

export default class SimpleTable extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        const data = this.props.object_of_table.data;
        const columns = this.props.object_of_table.columns;
        return (
            <div style={{padding: '50px'}}>
                <ReactTable
                    data={data}
                    columns={columns}
                    showPagination={false}
                    sortable={false}
                    // resizable={false}
                    resizable={true}
                    showPageSizeOptions={true}
                    style={{textAlign: "center"}}
                    defaultPageSize={data.length}
                    pageSize={data.length}
                />
            </div>
        );
    }
}