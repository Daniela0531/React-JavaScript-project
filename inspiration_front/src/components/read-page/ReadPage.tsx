import React from 'react';
import "./ReadPage.css";
import MyButton from "../../styles/common-components/my-button/MyButton";
import MyComponentField from "../../styles/common-components/my-component/MyComponent";
import MyPanel from "../../styles/common-components/my-panel/MyPanel";

import {testText} from "../../test/TestText"

function ReadPage() {
    return (
        <div className="read-page">
            <div className="read-page-back-button-wrapper">
                <MyButton
                    name="Back to stories"
                    path="../main-reader-page"
                    backgroundColor="var(--rm-secondary-main)"
                    color="var(--rm-text-secondary)"
                />
            </div>

            <div className="read-page-panel-wrapper">
                <MyPanel
                    style="read-page-panel-components-wrapper"
                    components={[
                        <div className="read-page-story-name-wrapper">
                            <MyComponentField
                                name="Story name very long story name"
                                backgroundColor="var(--rm-primary-middle)"
                                color="var(--rm-text-title)"
                            />
                        </div>,
                        <div className="read-page-story-chapter-wrapper">
                            <MyComponentField
                                name="Chapter 1000"
                                backgroundColor="var(--rm-secondary-middle)"
                                color="var(--rm-text-title)"
                            />
                        </div>
                    ]}
                />
            </div>

            <div className="read-page-text-field">
                <div className="read-page-text">
                    {testText}
                </div>
            </div>
        </div>
    )
}

export default ReadPage;