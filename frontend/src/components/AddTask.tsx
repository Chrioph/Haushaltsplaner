import React, {useState} from 'react';
import TextField from '@materal-ui/core/textfield';

export default function AddTask() {
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [] = useState("");
    const [] = useState("");

    return (
        <div>
            <form>
                <TextField id="task-name" label="Task Name" variant="outlined"
                           value={name}
                           onChange={(e: Event): void => setName((e.target as HTMLTextAreaElement).value)}
                />
                <TextField id="task-desc" label="Task Description" variant="outlined"
                           value={description}
                           onChange={(e: Event): void => setDescription((e.target as HTMLTextAreaElement).value)}
                />
            </form>
        </div>
    );
}