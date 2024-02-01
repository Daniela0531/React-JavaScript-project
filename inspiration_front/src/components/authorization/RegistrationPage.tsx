import React from 'react';
import "./AuthorizationPage.css";
import MyButton from "../../styles/common-components/my-button/MyButton";
import MyInputField from "../../styles/common-components/my-input-field/InputField";
import MyPanel from "../../styles/common-components/my-panel/MyPanel";
import MyTitle from "../../styles/common-components/my-title/MyTitle";
import {useNavigate} from "react-router-dom";

function RegistrationPage() {
    const navigate = useNavigate()
    let params = {
        name: null,
        password: null,
        mail: null
    }

    const registerHandler = () => {
        fetch(`http://127.0.0.1:8080/users/add/${params.name}/${params.password}/${params.mail}`, {method: "POST", headers: {"Content-Type": "application/json"}})
            .then(r => {
                console.log('registration OK')
                navigate('/main-writer-page')
            }).catch(value => console.log(`zepka: ${value}`))
    }
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
                    <div className="authorization-page-panel-proportions">
                        <div className="authorization-page-title-wrapper">
                            <MyTitle
                                color=""
                                name="Inspiration"
                            />
                        </div>
                        <MyPanel
                            style="authorization-page-panel-components-wrapper"
                            components={[
                                <MyInputField
                                    name="name"
                                    backgroundColor="var(--rg-secondary-main)"
                                    params={params}
                                />,
                                <MyInputField
                                    name="password"
                                    backgroundColor="var(--rg-secondary-main)"
                                    params={params}
                                />,
                                <MyInputField
                                    name="mail"
                                    backgroundColor="var(--rg-secondary-main)"
                                    params={params}
                                />,
                                <MyButton
                                    name="Register"
                                    path="/main-reader-page/authorization-page"
                                    backgroundColor="var(--rg-secondary-main)"
                                    color="var(--rg-text-secondary)"
                                    handler={registerHandler}
                                />
                            ]}
                        />
                    </div>
                </div>
            </div>
        </div>
    )
}

export default RegistrationPage;