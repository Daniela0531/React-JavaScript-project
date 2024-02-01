import React from 'react';
import "./MyComponent.css"

export interface MyComponentField {
    name?: string,
    color?: string,
    backgroundColor: string
}

function MyComponentField(props: MyComponentField) {
    return (
        <div className="component-field-style" style={{backgroundColor: props.backgroundColor, color: props.color}}>
            {props.name}
        </div>
    )
}

export default MyComponentField;