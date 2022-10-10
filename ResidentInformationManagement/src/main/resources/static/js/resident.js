function fetchResidents(endpoint) {
    fetch(endpoint).then(function (response) {
        return response.json();
    }).then(function (data) {
            console.info(data);
            let message = "";
            for (let i = 0; i < data.length; i++) {
                message += `
                <tr id="row_${data[i].id}">
                    <td>${data[i].id}</td>
                    <td>${data[i].name}</td>
                    <td>${moment(data[i].dob).format("DD/MM/YYYY")}</td>
                    <td>${data[i].gender}</td>
                    <td>${data[i].phone}</td>
                    <td>${data[i].email}</td>
                    <td>${data[i].address}</td>
                    <td>
                        <a href="${window.location.href + '/update/' + data[i].id}" class="edit" data-toggle="modal"><i class="material-icons"
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
                                    <h4 class="modal-title">Delete Resident</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <p>Are you sure you want to delete these record?</p>
                                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                    <input type="button" class="btn btn-danger" value="Delete" onclick="deleteResident('${endpoint + '/' + data[i].id}', '${data[i].id}')">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                `;
                let residentList = document.getElementById("resident_list");
                residentList.innerHTML = message;
            }
        }
    );
}

function deleteResident(endpoint, id) {
    fetch(endpoint, {method: "DELETE"}).then(function (response) {
        if (response.status == 204) {
            $(`#delete_${id}`).modal("hide");
            fetchResidents(endpoint.substring(0, endpoint.lastIndexOf("/")));
        }
    }).catch(function (error) {
        console.error(error);
        $("#error_content").html(error);
        $("#delete_resident_error").modal("show");
    })
}