import React from "react";
import '../../index.css';
import fillToTable from "../../functions/fillToTable";
import {store} from "../../components/App";
import {SET_STRING_XML} from "../../store/tree/actions";

export default class NodeViewsForOfflineMode extends React.Component {
    constructor(props) {
        super(props);
        this.state = {visible_children: true, click: true, oneLoad: false};
        this.onClickButton = this.onClickButton.bind(this);
        this.onClickText = this.onClickText.bind(this);
    }

    onClickText() {
        store.dispatch({
            type: SET_STRING_XML,
            payload: {
                stringXML: {string: ""},
            }
        });
        this.props.setDataTable(fillToTable(this.props.object_of_tree.data.map));
    }

    async onClickButton() {
        // if (this.props.object_of_tree.children.length === 0)
        {
        //     this.setState({mouse: false});
        //     fetch('http://localhost:8080/load', {
        //         method: "POST",
        //         headers: {
        //             'Accept': 'application/json',
        //             'Content-Type': 'application/json',
        //         },
        //         body: JSON.stringify({id: this.props.object_of_tree.data.map.id})
        //     })
        //         .then(function (response) {
        //             if (response.ok) {
        //                 return response.json();
        //             }
        //             {
        //                 throw new Error("Post Failed")
        //             }
        //         })
        //         .then(responseBody => {
        //             this.props.setTree(responseBody);
        //             return (responseBody);
        //         })
        //         .then(responseBody => {
        //             store.dispatch({
        //                 type: SET_STRING_XML,
        //                 payload: {
        //                     stringXML: {string: ""},
        //                 }
        //             });
        //             return (responseBody);
        //         })
        //         .then(responseBody => {
        //             let array_index_was_one_click = this.props.index_was_one_click;
        //             let set_index_was_one_click = new Set(array_index_was_one_click);
        //             let array_index_plus = this.props.index_plus;
        //             let set_index_plus = new Set(array_index_plus);
        //             let array_index_minus = this.props.index_minus;
        //             let set_index_minus = new Set(array_index_minus);
        //             let array_index_zero = this.props.index_zero;
        //             let set_index_zero = new Set(array_index_zero);
        //
        //             if (!set_index_was_one_click.has(this.props.object_of_tree.data.map.id)) {
        //                 set_index_minus.add(this.props.object_of_tree.data.map.id);
        //             }
        //             // ---------------------------------------------------------------------------------------------------------
        //             else if (set_index_zero.has(this.props.object_of_tree.data.map.id)) {
        //                 set_index_zero.add(this.props.object_of_tree.data.map.id)
        //             }
        //             // ---------------------------------------------------------------------------------------------------------
        //             else if (set_index_plus.has(this.props.object_of_tree.data.map.id)) {
        //                 set_index_minus.add(this.props.object_of_tree.data.map.id);
        //                 set_index_plus.delete(this.props.object_of_tree.data.map.id);
        //             } else if (set_index_minus.has(this.props.object_of_tree.data.map.id)) {
        //                 set_index_plus.add(this.props.object_of_tree.data.map.id);
        //                 set_index_minus.delete(this.props.object_of_tree.data.map.id);
        //             }
        //
        //             set_index_was_one_click.add(this.props.object_of_tree.data.map.id);
        //
        //             const {setIndexWasOneClick} = this.props;
        //             array_index_was_one_click = [...set_index_was_one_click];
        //             setIndexWasOneClick(array_index_was_one_click);
        //
        //             const {setIndexMinus} = this.props;
        //             array_index_minus = [...set_index_minus];
        //             setIndexMinus(array_index_minus);
        //
        //             const {setIndexPlus} = this.props;
        //             array_index_plus = [...set_index_plus];
        //             setIndexPlus(array_index_plus);
        //
        //             const {setIndexZero} = this.props;
        //             array_index_zero = [...set_index_zero];
        //             setIndexZero(array_index_zero);
        //             return (responseBody);
        //         })
        //         .then(() => this.props.setDataTable(fillToTable(this.props.object_of_tree.data.map)))
        //         .then(() => {
        //             this.setState({mouse: true});
        //         })
        //         .catch(function (error) {
        //             console.log("Request failed", error);
        //         });
        //
        // } else {
        //     store.dispatch({
        //         type: SET_STRING_XML,
        //         payload: {
        //             stringXML: {string: ""},
        //         }
        //     });

            this.props.setDataTable(fillToTable(this.props.object_of_tree.data.map));
            let array_index_was_one_click = this.props.index_was_one_click;
            let set_index_was_one_click = new Set(array_index_was_one_click);
            let array_index_plus = this.props.index_plus;
            let set_index_plus = new Set(array_index_plus);
            let array_index_minus = this.props.index_minus;
            let set_index_minus = new Set(array_index_minus);
            let array_index_zero = this.props.index_zero;
            let set_index_zero = new Set(array_index_zero);

            if (!set_index_was_one_click.has(this.props.object_of_tree.data.map.id)) {
                set_index_minus.add(this.props.object_of_tree.data.map.id);
            }
            // ---------------------------------------------------------------------------------------------------------
            else if (set_index_zero.has(this.props.object_of_tree.data.map.id)) {
                set_index_zero.add(this.props.object_of_tree.data.map.id)
            }
            // ---------------------------------------------------------------------------------------------------------
            else if (set_index_plus.has(this.props.object_of_tree.data.map.id)) {
                set_index_minus.add(this.props.object_of_tree.data.map.id);
                set_index_plus.delete(this.props.object_of_tree.data.map.id);
            } else if (set_index_minus.has(this.props.object_of_tree.data.map.id)) {
                set_index_plus.add(this.props.object_of_tree.data.map.id);
                set_index_minus.delete(this.props.object_of_tree.data.map.id);
            }

            set_index_was_one_click.add(this.props.object_of_tree.data.map.id);

            const {setIndexWasOneClick} = this.props;
            array_index_was_one_click = [...set_index_was_one_click];
            setIndexWasOneClick(array_index_was_one_click);

            const {setIndexMinus} = this.props;
            array_index_minus = [...set_index_minus];
            setIndexMinus(array_index_minus);

            const {setIndexPlus} = this.props;
            array_index_plus = [...set_index_plus];
            setIndexPlus(array_index_plus);

            const {setIndexZero} = this.props;
            array_index_zero = [...set_index_zero];
            setIndexZero(array_index_zero);
            this.setState({mouse: true})
        }
    }

    render() {

        let button_text = "";
        let visible_children_boolean;
        let array_index_was_one_click = this.props.index_was_one_click;
        let set_index_was_one_click = new Set(array_index_was_one_click);
        let array_index_plus = this.props.index_plus;
        let set_index_plus = new Set(array_index_plus);
        let array_index_minus = this.props.index_minus;
        let set_index_minus = new Set(array_index_minus);
        let array_index_zero = this.props.index_zero;
        let set_index_zero = new Set(array_index_zero);

        if (!set_index_was_one_click.has(this.props.object_of_tree.data.map.id)) {
            button_text = "#";
        } else if (set_index_zero.has(this.props.object_of_tree.data.map.id)) {
            button_text = '0';
        } else if (set_index_minus.has(this.props.object_of_tree.data.map.id)) {
            button_text = '-';
            visible_children_boolean = true;
            if (this.props.object_of_tree.children.length === 0){
                set_index_zero.add(this.props.object_of_tree.data.map.id);
                const {setIndexZero} = this.props;
                array_index_zero = [...set_index_zero];
                setIndexZero(array_index_zero);

            }
        } else if (set_index_plus.has(this.props.object_of_tree.data.map.id)) {
            button_text = "+";
            visible_children_boolean = false;
            if(this.props.object_of_tree.children.length === 0){
                set_index_zero.add(this.props.object_of_tree.data.map.id);
                const {setIndexZero} = this.props;
                array_index_zero = [...set_index_zero];
                setIndexZero(array_index_zero);
            }
        }

        return (
            <React.Fragment >

                <button className="button" onClick={this.onClickButton}>{button_text}</button>
                <div className="inline-text-for-node"
                     onClick={this.onClickText}> &nbsp;{((this.props.object_of_tree.data.map.nameNode === "root") || (this.props.object_of_tree.data.map.nameNode === "schemas") || (this.props.object_of_tree.data.map.nameNode === "tables") || (this.props.object_of_tree.data.map.nameNode === "columns") || (this.props.object_of_tree.data.map.nameNode === "views") || (this.props.object_of_tree.data.map.nameNode === "procedures") || (this.props.object_of_tree.data.map.nameNode === "functions") || (this.props.object_of_tree.data.map.nameNode === "triggers") || (this.props.object_of_tree.data.map.name === undefined)) ? "" : this.props.object_of_tree.data.map.nameNode + ": "}{this.props.object_of_tree.data.map.name}</div>
                {this.props.object_of_tree.children.map(node => (
                    <div className="simple-style" key={node.data.map.id}>
                        {visible_children_boolean ?
                            <NodeViewsForOfflineMode object_of_tree={node}
                                        flag={this.props.flag}
                                        index_was_one_click={this.props.index_was_one_click}
                                        index_minus={this.props.index_minus}
                                        index_plus={this.props.index_plus}
                                        index_zero={this.props.index_zero}

                                        setFlag={this.props.setFlag}
                                        setTree={this.props.setTree}
                                        setDataTable={this.props.setDataTable}
                                        setIndexWasOneClick={this.props.setIndexWasOneClick}
                                        setIndexMinus={this.props.setIndexMinus}
                                        setIndexPlus={this.props.setIndexPlus}
                                        setIndexZero={this.props.setIndexZero}
                            /> : null}
                    </div>

                ))}
            </React.Fragment>
        );
    }
}