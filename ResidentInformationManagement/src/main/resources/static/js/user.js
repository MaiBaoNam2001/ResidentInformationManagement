function fetchUsers(endpoint) {
    fetch(endpoint).then(function (response) {
        return response.json();
    }).then(function (data) {
        console.info(data);
        let message = "";
        for (let i = 0; i < data.length; i++) {
            message += `
            <tr id="row_${data[i].id}">
                <td>${data[i].id}</td>
                <td>${data[i].resident.name}</td>
                <td>${data[i].username}</td>
                <td>${data[i].password.substr(0, 16) + "..."}</td>
                <td>${moment(data[i].createdDate).format("DD/MM/YYYY")}</td>
                <td>${data[i].role.name}</td>
                <td>
                    <a href="#" class="edit" data-toggle="modal"><i class="material-icons"
                                                                                     data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                    <a href="#delete_${data[i].id}" class="delete" data-toggle="modal"><i class="material-icons"
                                                                                         data-toggle="tooltip"
                                                                                         title="Delete">&#xE872;</i></a>
                </td>
            </tr>
            
            <div id="delete_${data[i].id}" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form>
                            <div class="modal-header">
                                <h4 class="modal-title">Delete User</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <p>Are you sure you want to delete these record?</p>
                                <p class="text-warning"><small>This action cannot be undone.</small></p>
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="button" class="btn btn-danger" value="Delete">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            `;
            let userList = document.getElementById("user_list");
            userList.innerHTML = message;
        }
    });
}

function loadSelectData(endpoint, id) {
    fetch(endpoint).then(function (response) {
        return response.json();
    }).then(function (data) {
        console.info(data);
        let message = "";
        for (let i = 0; i < data.length; i++) {
            message += `<option value="${data[i].id}">${data[i].name}</option>`
        }
        document.getElementById(id).innerHTML = message;
    })
}