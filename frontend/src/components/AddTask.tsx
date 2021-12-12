import React, {useState} from 'react';

export default function AddTask() {
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");

    function handleNameChange(event: React.SyntheticEvent<EventTarget>) {
        setName((event.target as HTMLTextAreaElement).value);
    }

    function handleDescChange(event: React.SyntheticEvent<EventTarget>) {
        setDescription((event.target as HTMLTextAreaElement).value);
    }

    return (
        <div>
            <form method="post">
                <div className="form-group">
                    <label className="formElement">Task Name</label>
                    <input type="text" id="task-name"
                           className="form-control formElement"
                           name="Task Name"
                           value={name}
                           placeholder="Task name"
                           onChange={handleNameChange}
                    />
                </div>
                <div className="input-group-prepend">
                    <label className="formElement">Description</label>
                    <input type="text" id="task-desc"
                           className="form-control formElement"
                           name="Task Description"
                           value={description}
                           placeholder="Description"
                           onChange={handleDescChange}
                    />
                </div>
                <button type="submit" className="btn btn-primary formElement">Submit</button>
            </form>
        </div>
    );
}