import React from 'react';
import "./AuthorizationPage.css";
import MyButton from "../../styles/common-components/my-button/MyButton";
import MyInputField from "../../styles/common-components/my-input-field/InputField";
import MyPanel from "../../styles/common-components/my-panel/MyPanel";
import MyTitle from "../../styles/common-components/my-title/MyTitle";

function PasswordRestorationPage() {
    return (
        <div className="authorization-style-img">
            <div className="authorization-style-gradient">

                <div className="authorization-style-button-position">
                    <MyButton
                        name="Back"
                        path="/main-reader-page/authorization-page"
                        backgroundColor="var(--rg-secondary-main)"
                        color="var(--rg-text-secondary)"
                    />
                </div>

                <div className="authorization-style-panel-position">
                    <div className="restoration-page-panel-proportions">
                        <div className="restoration-page-title-wrapper">
                            <MyTitle
                                color=""
                                name="Inspiration"
                            />
                        </div>
                        <MyPanel
                            style="restoration-page-panel-components-wrapper"
                            components={[
                                <MyInputField
                                    name="name"
                                    backgroundColor="var(--rg-secondary-main)"
                                />
                            ]}
                        />
                    </div>
                </div>
            </div>
        </div>
    )
}


export default PasswordRestorationPage;