import React from 'react';
import "./MyPanel.css";
// import {StoryInfo} from "../story/Story";

export interface MyPanel {
    style: string,
    components: JSX.Element[]
}

function MyPanel(props: MyPanel) {
    return (
        <div className={props.style}>
            {props.components.map((input: any)=>input)}
        </div>
    )
}
export default MyPanel;