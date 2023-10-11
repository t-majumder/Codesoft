import tkinter as tk
from tkinter import messagebox

def add_task():
    task = entry_task.get()
    if task:
        listbox_tasks.insert(tk.END, task)
        entry_task.delete(0, tk.END)
    else:
        messagebox.showwarning("Warning", "Please enter a task.")

def delete_task():
    try:
        selected_task_index = listbox_tasks.curselection()[0]
        listbox_tasks.delete(selected_task_index)
    except IndexError:
        messagebox.showwarning("Warning", "Please select a task to delete.")

# Create the main window
root = tk.Tk()
root.title("T O D O   L I S T")
root.geometry("400x560")  # Set the initial size

# Background color for the main window
root.configure(bg="#f0f0f0")

# Create an entry widget for adding tasks
entry_task = tk.Entry(root, width=40, font=("Arial", 14))
entry_task.pack(pady=10)

# Edit task
def edit_task():
    try:
        selected_task_index = listbox_tasks.curselection()[0]
        edited_task = entry_task.get()
        if edited_task:
            listbox_tasks.delete(selected_task_index)
            listbox_tasks.insert(selected_task_index, edited_task)
            entry_task.delete(0, tk.END)
        else:
            messagebox.showwarning("Warning", "Please enter an edited task.")
    except IndexError:
        messagebox.showwarning("Warning", "Please select a task to edit.")

# Create a frame for buttons to organize them side by side
button_frame = tk.Frame(root)
button_frame.pack()

# Create a button to add tasks
add_button = tk.Button(button_frame, text="Add Task", command=add_task, bg="orange", fg="white", font=("Arial", 14))
add_button.pack(side=tk.LEFT, padx=5)

# Create a button to edit tasks
edit_button = tk.Button(button_frame, text="Edit Task", command=edit_task, bg="#4286f4", fg="white", font=("Arial", 14))
edit_button.pack(side=tk.LEFT, padx=5)

# Create a listbox to display tasks
listbox_tasks = tk.Listbox(root, width=40, height=20, font=("Arial", 12, "bold"))
listbox_tasks.pack()

# Create a button to delete tasks
delete_button = tk.Button(root, text="Delete Task", command=delete_task, bg="#FF5733", fg="white", font=("Arial", 14))
delete_button.pack()

# Start the GUI main loop
root.mainloop()
