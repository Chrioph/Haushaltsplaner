import React, {SyntheticEvent, useRef, useState} from "react";
import MenuIcon from '@mui/icons-material/Menu';
import {Button, ClickAwayListener, Grow, MenuItem, MenuList, Paper, Popper} from "@mui/material";


export default function Header (){
    const [open, setOpen] = useState(false);
    const anchorRef = useRef<HTMLButtonElement>(null);

    const handleToggle = () => {
        setOpen(!open);
    }

    const handleClose = (e: Event | SyntheticEvent) => {
        if (
            anchorRef.current &&
            anchorRef.current.contains(e.target as HTMLElement)
        ) {
            return;
        }
        setOpen(false);
    }

    return <div>
        <div className="Header">
            <Button
                ref={anchorRef}
                id="composition-button"
                aria-controls={open ? 'composition-menu' : undefined}
                aria-expanded={open ? 'true' : undefined}
                aria-haspopup="true"
                onClick={handleToggle}
            >
                <MenuIcon
                    className="Menu"
                    style={{color: "white", margin:'0.5em'}}
                ></MenuIcon>
            </Button>
            <Popper
                open={open}
                anchorEl={anchorRef.current}
                placement="bottom-start"
                transition
                disablePortal
            >
                {({ TransitionProps, placement}) => (
                <Grow
                    {...TransitionProps} style={{
                    transformOrigin:
                        placement === 'bottom-start' ? 'left top' : 'left bottom',
                }}
                >
                    <Paper
                        style={{backgroundColor: "#53E3D4", width:'200px', height:'10000px', borderRadius:"0px", color:"white"}}
                    >
                        <ClickAwayListener onClickAway={handleClose}>
                            <MenuList
                                autoFocusItem={open}
                                id="composition-menu"
                                aria-labelledby="composition-button"
                            >
                                <MenuItem>Leistungen</MenuItem>
                                <MenuItem>Über mich</MenuItem>
                                <MenuItem>Impressum</MenuItem>
                            </MenuList>
                        </ClickAwayListener>
                    </Paper>
                </Grow>
                )}
            </Popper>
            <h1>
                <a href={"/home"} className="Link"> Webentwicklung Hegerath </a>
            </h1>

        </div>
    </div>
}