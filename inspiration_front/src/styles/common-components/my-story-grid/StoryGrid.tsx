import Story, {MyStoryInfo} from "../my-story/MyStory";
import {v4 as uuidv4} from "uuid";
import React from "react";
import "./StoryGrid.css"

function MyStoryGrid(props: {stories: MyStoryInfo[]}) {
    let row = []
    let columns = []
    const len = props.stories.length
    for (let idx = 0; idx < len; ++idx) {
        if (row.length >= 4) {
            columns.push(row)
            row = []
        }
        row.push(props.stories[idx])
    }
    if (row.length > 0) {
        columns.push(row)
    }

    const columnsComponent = columns.map((column) => {
        const columnComponent = column.map((input) => {
            return <Story key={uuidv4()} {...input}/>
        })

        return (
            <div key={uuidv4()} className="rows-style">
                {columnComponent}
            </div>
        )
    })
    return (
        <div className="scroll-style">
            <div className="columns-style">
                {columnsComponent}
            </div>
        </div>
    )
}

export default MyStoryGrid;