import React, {useEffect, useState} from "react";
import {getTasks} from "../services/TaskService";

export default function Tasks() {
    const [tasks, setTasks] = useState([]);

    useEffect(() => {
        getTasks().then((response) => {
            setTasks(response.data)
        });
    }, []);

    const taskElements = tasks.slice(0, 10).map(({id, title, description}) =>
        <div key={id} className="list-group-item"><label>{title}</label>: <label>{description}</label></div>
    )

    return (
        <div>
            <h4>Tasks</h4>
            {taskElements}
        </div>
    )


}