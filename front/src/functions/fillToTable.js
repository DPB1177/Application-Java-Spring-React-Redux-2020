export default function fillToTable(maping) {
    let objectForTable = {data: [], columns: []};
    if (maping.nameNode === "root") {
        for (let key in maping) {
            if (key === "nameNode") {
                objectForTable.data.push({name: "node", property: maping[key]});
            }else if (key === "nameDataBase"){
                objectForTable.data.push({name: "name data base", property: maping[key]});
            }
            // else if (key === "id"){
            //     objectForTable.data.push({name: "id", property: maping[key]});
            // }
        }
        // objectForTable.columns.push({
        //     Header: 'Name',
        //     accessor: 'name',
        //     style: { 'white-space': 'unset' }
        // },{
        //     Header: 'properties',
        //     accessor: 'property',
        //     style: { 'white-space': 'unset' }
        // });
        // return objectForTable;
    }
    else if (maping.nameNode === "schemas" || maping.nameNode === "tables" || maping.nameNode === "columns" || maping.nameNode === "functions" || maping.nameNode === "procedures" || maping.nameNode === "triggers" || maping.nameNode === "views") {
        for (let key in maping) {
            if (key === "nameNode") {
                objectForTable.data.push({name: "node", property: maping[key]});
            }
            // else if (key === "id"){
            //     objectForTable.data.push({name: "id", property: maping[key]});
            // }

        }
        // objectForTable.columns.push({
        //     Header: 'Name',
        //     accessor: 'name',
        //     style: { 'white-space': 'unset' }
        // },{
        //     Header: 'properties',
        //     accessor: 'property',
        //     style: { 'white-space': 'unset' }
        // });
        // return objectForTable;
    } else if (maping.nameNode === "schema") {
        for (let key in maping) {
            if (key === "nameNode") {
                objectForTable.data.push({name: "node", property: maping[key]});
            }else if (key === "name"){
                objectForTable.data.push({name: "name", property: maping[key]});
            }
            // else if (key === "id"){
            //     objectForTable.data.push({name: "id", property: maping[key]});
            // }

        }
        // objectForTable.columns.push({
        //     Header: 'Name',
        //     accessor: 'name',
        //     style: { 'white-space': 'unset' }
        // },{
        //     Header: 'properties',
        //     accessor: 'property',
        //     style: { 'white-space': 'unset' }
        // });
        // return objectForTable;
    } else if (maping.nameNode === "table") {
        for (let key in maping) {
            if (key === "nameNode") {
                objectForTable.data.push({name: "node", property: maping[key]});
            }
            if (key === "name"){
                objectForTable.data.push({name: "name", property: maping[key]});
            }
            if (key === "tableCreateTime"){
                objectForTable.data.push({name: "create time", property: maping[key]});
            }
            if (key === "tableRows"){
                objectForTable.data.push({name: "rows", property: maping[key]});
            }
            if (key === "tableAvgRowLength"){
                objectForTable.data.push({name: "avg row length", property: maping[key]});
            }
            if (key === "tableVersion"){
                objectForTable.data.push({name: "version", property: maping[key]});
            }
            if (key === "createTableDLL"){
                objectForTable.data.push({name: "DDL", property: maping[key]});
            }
            // else if (key === "id"){
            //     objectForTable.data.push({name: "id", property: maping[key]});
            // }

        }
        // objectForTable.columns.push({
        //     Header: 'Name',
        //     accessor: 'name',
        //     style: { 'white-space': 'unset' }
        // },{
        //     Header: 'Properties',
        //     accessor: 'property',
        //     style: { 'white-space': 'unset' }
        // });
        // console.log(objectForTable.data);
        // return objectForTable;
    } else if (maping.nameNode === "column") {
        for (let key in maping) {
            if (key === "nameNode") {
                objectForTable.data.push({name: "node", property: maping[key]});
            }else if (key === "name"){
                objectForTable.data.push({name: "name", property: maping[key]});
            }
            else if (key === "nameColumnType"){
                objectForTable.data.push({name: "type", property: maping[key]});
            }
            // else if (key === "id"){
            //     objectForTable.data.push({name: "id", property: maping[key]});
            // }
        }
        // objectForTable.columns.push({
        //     Header: 'Name',
        //     accessor: 'name',
        //     style: { 'white-space': 'unset' }
        // },{
        //     Header: 'properties',
        //     accessor: 'property',
        //     style: { 'white-space': 'unset' }
        // });
        // return objectForTable;
    }
    else if (maping.nameNode === "function") {
        for (let key in maping) {
            if (key === "nameNode") {
                objectForTable.data.push({name: "node", property: maping[key]});
            }else if (key === "name"){
                objectForTable.data.push({name: "name", property: maping[key]});
            }
            else if (key === "createFunctionDLL"){
                objectForTable.data.push({name: "DDL", property: maping[key]});
            }
            // else if (key === "id"){
            //     objectForTable.data.push({name: "id", property: maping[key]});
            // }
        }
        // objectForTable.columns.push({
        //     Header: 'Name',
        //     accessor: 'name',
        //     style: { 'white-space': 'unset' }
        // },{
        //     Header: 'properties',
        //     accessor: 'property',
        //     style: { 'white-space': 'unset' }
        // });
        // return objectForTable;
    }
    else if (maping.nameNode === "procedure") {
        for (let key in maping) {
            if (key === "nameNode") {
                objectForTable.data.push({name: "node", property: maping[key]});
            }else if (key === "name"){
                objectForTable.data.push({name: "name", property: maping[key]});
            }
            else if (key === "createProcedureDLL"){
                objectForTable.data.push({name: "DDL", property: maping[key]});
            }
            // else if (key === "id"){
            //     objectForTable.data.push({name: "id", property: maping[key]});
            // }
        }
        // objectForTable.columns.push({
        //     Header: 'Name',
        //     accessor: 'name',
        //     style: { 'white-space': 'unset' }
        // },{
        //     Header: 'properties',
        //     accessor: 'property',
        //     style: { 'white-space': 'unset' }
        // });
        // return objectForTable;
    }
    else if (maping.nameNode === "trigger") {
        for (let key in maping) {
            if (key === "nameNode") {
                objectForTable.data.push({name: "node", property: maping[key]});
            }else if (key === "name"){
                objectForTable.data.push({name: "name", property: maping[key]});
            }
            else if (key === "createTriggerDLL"){
                objectForTable.data.push({name: "DDL", property: maping[key]});
            }
            // else if (key === "id"){
            //     objectForTable.data.push({name: "id", property: maping[key]});
            // }
        }
        // objectForTable.columns.push({
        //     Header: 'Name',
        //     accessor: 'name',
        //     style: { 'white-space': 'unset' }
        // },{
        //     Header: 'properties',
        //     accessor: 'property',
        //     style: { 'white-space': 'unset' }
        // });
        // return objectForTable;
    }
    else if (maping.nameNode === "view") {
        for (let key in maping) {
            if (key === "nameNode") {
                objectForTable.data.push({name: "node", property: maping[key]});
            }else if (key === "name"){
                objectForTable.data.push({name: "name", property: maping[key]});
            }
            else if (key === "createViewDLL"){
                objectForTable.data.push({name: "DDL", property: maping[key]});
            }
            // else if (key === "id"){
            //     objectForTable.data.push({name: "id", property: maping[key]});
            // }
        }
        // objectForTable.columns.push({
        //     Header: 'Name',
        //     accessor: 'name',
        //     style: { 'white-space': 'unset' }
        // },{
        //     Header: 'properties',
        //     accessor: 'property',
        //     style: { 'white-space': 'unset' }
        // });
        // return objectForTable;
    }

    // return ({
    //     data: [{
    //         name: '',
    //         age: ''
    //     },
    //     ],
    //     columns: [
    //         {
    //             Header: "",
    //             accessor: 'name'
    //         }
    //         , {
    //             Header: '',
    //             accessor: 'age'
    //         }
    //     ]
    // })

    objectForTable.columns.push({
        Header: 'key',
        accessor: 'name',
        style: { 'white-space': 'unset' }
    },{
        Header: 'properties',
        accessor: 'property',
        style: { 'white-space': 'unset' }
    });
    return objectForTable;



}