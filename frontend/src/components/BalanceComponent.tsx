import React, {useEffect, useState} from "react";
import {getBalance} from "../services/BalanceService";
import {HOUSEHOLDS} from "../enum/HOUSEHOLDS";
import {FormControl, InputLabel, MenuItem, Select, SelectChangeEvent, TextField} from "@mui/material";

export default function BalanceComponent() {
    const [household, setHousehold] = useState("");
    const [balance, setBalance] = useState(getBalance(household));

    /*useEffect(() => {
        getBalance(household).then((response) => {
            setBalance(response.data)
        });
    }, [household]);*/

    useEffect(() => {
        setBalance(getBalance(household))
    }, [household, balance])

    const handleChange = (e: SelectChangeEvent) => {
        e.preventDefault()
        setHousehold(e.target.value)
        setBalance(getBalance(household))
    }

    return (
        <div  className={"formElement"}>
                <div className="flex-box">
                    <h4>Kontostand</h4>
                    <FormControl fullWidth>
                        <InputLabel>Haushalt</InputLabel>
                        <Select
                            value={household}
                            onChange={handleChange}
                        >
                            <MenuItem value={HOUSEHOLDS.GJ}>Garnet und Jörg</MenuItem>
                            <MenuItem value={HOUSEHOLDS.JC}>Jasmin und Christoph</MenuItem>
                        </Select>
                    </FormControl>
                        {balance ? <div className="flex-content balance balance-form">{balance + "€"}</div> : <></>}
                    <FormControl>
                        <InputLabel>Betrag</InputLabel>
                        <TextField
                            type="number"
                            InputLabelProps={{
                                shrink: true,
                            }}
                        />
                    </FormControl>
                </div>
        </div>
    )


}