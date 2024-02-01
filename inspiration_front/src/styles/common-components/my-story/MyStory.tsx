import React from 'react';
import {useNavigate} from "react-router-dom";
import "./MyStory.css"

export interface MyStoryInfo {
    name: string,
    path: string,
    color: string,
    backgroundColor: string
}
function MyStory(props: MyStoryInfo) {
    const navigate = useNavigate();
    return (
        <div className="story-style"
             style={{color: props.color, backgroundColor: props.backgroundColor}}
             onClick={() => navigate(`${props.path}`)}>
            <div className="story-text-style">
                {props.name}
            </div>
        </div>
    )
}
export default MyStory;