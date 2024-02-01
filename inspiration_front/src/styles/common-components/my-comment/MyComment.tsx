import React from 'react';
import "./MyComment.css";

export interface MyComment {
    text: string,
    color: string
}

function MyComment(props: MyComment) {
    return (
        <div className="authorization-style-comment" style={{color: props.color}}>
            {props.text}
        </div>
    )
}
export default MyComment;