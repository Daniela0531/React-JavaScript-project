import React from 'react';
import "./MyTitle.css"

export interface MyTitle {
    name: string,
    color: string
}
function MyTitle(props: MyTitle) {
    return (
        <div className="authorization-style-title" style={{color: props.color}}>
            {props.name}
        </div>
    )
}

export default MyTitle;