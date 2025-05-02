document.addEventListener('DOMContentLoaded', function() {
    loadTodos();

    document.getElementById('todo-form').addEventListener('submit', function(e) {
        e.preventDefault();
        const newTodo = {
            title: document.getElementById('title').value,
            order: document.getElementById('order').value,
            completed: document.getElementById('completed').checked
        };

        fetch("/api", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newTodo)
        }).then(response => {
            if (response.ok) {
                loadTodos();
                document.getElementById('title').value = '';
                document.getElementById('order').value = '0';
                document.getElementById('completed').checked = false;
                showTab('list');
            }
        });
    });
});

function loadTodos() {
    fetch("/api")
        .then(response => response.json())
        .then(data => {
            const todoList = document.getElementById('todo-list');
            todoList.innerHTML = '';
            data.forEach(todo => {
                todoList.innerHTML += `
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.title}</td>
                        <td>${todo.order}</td>
                        <td>${todo.completed ? '완료' : '미완료'}</td>
                        <td><button onclick="openEditModal(${todo.id})">수정</button></td>
                        <td><button onclick="deleteTodo(${todo.id})">삭제</button></td>
                    </tr>
                `;
            });
        });
}

function deleteTodo(id) {
    fetch("/api/" + id, {
        method: "DELETE"
    }).then(response => {
        if (response.ok) {
            loadTodos();
        }
    });
}

function openEditModal(id) {
    fetch("/api/" + id)
        .then(response => response.json())
        .then(todo => {
            document.getElementById('edit-id').value = todo.id;
            document.getElementById('edit-title').value = todo.title;
            document.getElementById('edit-order').value = todo.order;
            document.getElementById('edit-completed').checked = todo.completed;
            document.getElementById('edit-modal').style.display = 'block';
        });
}

function updateTodo() {
    const id = document.getElementById('edit-id').value;
    const updatedTodo = {
        title: document.getElementById('edit-title').value,
        order: document.getElementById('edit-order').value,
        completed: document.getElementById('edit-completed').checked
    };

    fetch("/api/" + id, {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(updatedTodo)
    }).then(response => {
        if (response.ok) {
            closeModal();
            loadTodos();
        }
    });
}

function closeModal() {
    document.getElementById('edit-modal').style.display = 'none';
}

function showTab(tab) {
    document.querySelectorAll('.tab-content').forEach(el => el.style.display = 'none');
    document.getElementById(tab).style.display = 'block';
    document.querySelectorAll('.tab-button').forEach(btn => btn.classList.remove('active'));
    document.querySelector(`button[onclick="showTab('${tab}')"]`).classList.add('active');
}
