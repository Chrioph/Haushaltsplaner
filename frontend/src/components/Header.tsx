import React from "react";
import MenuIcon from '@mui/icons-material/Menu';


export default function Header (){
    return <div>
        <div className="Header">
            <MenuIcon className="Menu"></MenuIcon>
            <h1>
                <a href={"/home"} className="Link"> Webentwicklung Hegerath </a>
            </h1>

        </div>
    </div>
}