import tkinter as tk
from tkinter import messagebox

# Create an empty phonebook dictionary to store contacts
phonebook = {}

# Variable to store the name of the contact to be edited
edit_contact_name = ""

def add_contact():
    name = entry_name.get()
    phone = entry_phone.get()
    email = entry_email.get()
    address = entry_address.get()

    if name and phone:
        phonebook[name] = {
            "Phone": phone,
            "Email": email,
            "Address": address
        }
        messagebox.showinfo("Success", "Contact added successfully!")
        clear_entries()
    else:
        messagebox.showwarning("Warning", "Please enter a name and phone number.")

def view_contacts():
    contacts_list.delete(0, tk.END)
    for name, details in phonebook.items():
        contacts_list.insert(tk.END, f"Name: {name}  ;  Phone: {details['Phone']}")

def edit_contact():
    global edit_contact_name
    edit_contact_name = entry_search.get()
    if edit_contact_name in phonebook:
        contact_details = phonebook[edit_contact_name]
        entry_name.delete(0, tk.END)
        entry_phone.delete(0, tk.END)
        entry_email.delete(0, tk.END)
        entry_address.delete(0, tk.END)
        entry_name.insert(0, edit_contact_name)
        entry_phone.insert(0, contact_details['Phone'])
        entry_email.insert(0, contact_details['Email'])
        entry_address.insert(0, contact_details['Address'])
    else:
        messagebox.showwarning("Warning", "Contact not found.")

def update_contact():
    global edit_contact_name
    name = entry_name.get()
    phone = entry_phone.get()
    email = entry_email.get()
    address = entry_address.get()

    if name and phone:
        phonebook[edit_contact_name] = {
            "Phone": phone,
            "Email": email,
            "Address": address
        }
        messagebox.showinfo("Success", "Contact updated successfully!")
        edit_contact_name = ""
        clear_entries()
    else:
        messagebox.showwarning("Warning", "Please enter a name and phone number.")

def delete_contact():
    global edit_contact_name
    name = entry_search.get()
    if name in phonebook:
        del phonebook[name]
        messagebox.showinfo("Success", f"Contact '{name}' deleted successfully!")
        edit_contact_name = ""
        clear_entries()
    else:
        messagebox.showwarning("Warning", "Contact not found.")


def search_contact():
    name = entry_search.get()
    if name in phonebook:
        contact_details = phonebook[name]
        search_text.config(text=f"Name: {name}\nPhone: {contact_details['Phone']}\nEmail: {contact_details['Email']}\nAddress: {contact_details['Address']}")
    else:
        search_text.config(text="Contact not found.")

def clear_entries():
    entry_name.delete(0, tk.END)
    entry_phone.delete(0, tk.END)
    entry_email.delete(0, tk.END)
    entry_address.delete(0, tk.END)

# Create the main window
root = tk.Tk()
root.title("Phonebook App")
root.geometry("400x770")
root.configure(bg="black")

# Create and configure frames
add_frame = tk.Frame(root, bg="#f0f0f0")
add_frame.pack(pady=10)
view_frame = tk.Frame(root, bg="#f0f0f0")
view_frame.pack(pady=10)
edit_frame = tk.Frame(root, bg="#f0f0f0")
edit_frame.pack(pady=10)

# Create labels and entry widgets for adding contacts
label_name = tk.Label(add_frame, text="Name:", font=("Arial", 12), bg="#f0f0f0")
label_name.grid(row=0, column=0, padx=10, pady=5)
entry_name = tk.Entry(add_frame, width=30, font=("Arial", 12))
entry_name.grid(row=0, column=1, pady=5)

label_phone = tk.Label(add_frame, text="Phone:", font=("Arial", 12), bg="#f0f0f0")
label_phone.grid(row=1, column=0, padx=10, pady=5)
entry_phone = tk.Entry(add_frame, width=30, font=("Arial", 12))
entry_phone.grid(row=1, column=1, pady=5)

label_email = tk.Label(add_frame, text="Email:", font=("Arial", 12), bg="#f0f0f0")
label_email.grid(row=2, column=0, padx=10, pady=5)
entry_email = tk.Entry(add_frame, width=30, font=("Arial", 12))
entry_email.grid(row=2, column=1, pady=5)

label_address = tk.Label(add_frame, text="Address:", font=("Arial", 12), bg="#f0f0f0")
label_address.grid(row=3, column=0, padx=10, pady=5)
entry_address = tk.Entry(add_frame, width=30, font=("Arial", 12))
entry_address.grid(row=3, column=1, pady=5)

add_button = tk.Button(add_frame, text="Add Contact", command=add_contact, font=("Arial", 12), bg="orange", fg="white")
add_button.grid(row=4, columnspan=2, pady=10)

# Create a frame for viewing contacts
view_button = tk.Button(view_frame, text="View Contacts", command=view_contacts, font=("Arial", 12), bg="#4286f4", fg="white")
view_button.pack()

contacts_list = tk.Listbox(view_frame, width=40, height=10, font=("Arial", 12))
contacts_list.pack()

# Create a frame for editing and deleting and updating contacts
edit_label_frame = tk.LabelFrame(edit_frame, text="Edit/Delete Contact", font=("Arial", 12), bg="#f0f0f0")
edit_label_frame.pack(pady=10)

entry_search = tk.Entry(edit_label_frame, width=30, font=("Arial", 12))
entry_search.grid(row=0, column=0, padx=10, pady=5)

search_button = tk.Button(edit_label_frame, text="Search", command=search_contact, font=("Arial", 12), bg="#4286f4", fg="white")
search_button.grid(row=0, column=1, padx=10, pady=5)

search_text = tk.Label(edit_label_frame, text="", font=("Arial", 12), bg="#f0f0f0")
search_text.grid(row=1, column=0, padx=10, columnspan=2, pady=5)

edit_button = tk.Button(edit_label_frame, text="Edit", command=edit_contact, font=("Arial", 12), bg="orange", fg="white")
edit_button.grid(row=2, column=0, padx=10,columnspan=2, pady=5)

delete_button = tk.Button(edit_label_frame, text="Delete", command=delete_contact, font=("Arial", 12), bg="#FF5733", fg="white")
delete_button.grid(row=4, column=0,columnspan=2, pady=5)


update_button = tk.Button(edit_label_frame, text="Update", command=update_contact, font=("Arial", 12), bg="#4286f4", fg="white")
update_button.grid(row=3, column=0, padx=10,columnspan=2, pady=5)

# Start the GUI main loop
root.mainloop()
