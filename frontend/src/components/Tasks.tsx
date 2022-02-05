import React, {useEffect, useState} from "react";
import {getTasks} from "../services/TaskService";
import AddTaskComponent from "./AddTaskComponent";

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
            <h3>Add task</h3>
            <AddTaskComponent/>
        </div>
    )


}