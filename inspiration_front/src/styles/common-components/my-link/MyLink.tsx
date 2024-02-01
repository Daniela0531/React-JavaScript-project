import React from 'react';
import "./MyLink.css";
import {useNavigate} from "react-router-dom";

export interface MyLink {
    name: string,
    path: string,
    color: string
}

function MyLink(props: MyLink) {
    const navigate = useNavigate();
    return (
        <button className="authorization-page-link"
                style={{color: props.color}}
                onClick={() => navigate(`${props.path}`)}>
            {props.name}
        </button>
    )
}

export default MyLink;