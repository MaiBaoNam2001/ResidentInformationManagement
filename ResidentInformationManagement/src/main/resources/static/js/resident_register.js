$(function () {
    const endpoint = 'http://localhost:8081/api';

    $.fn.loadSelectData = function (endpoint, id, eventType) {
        $('#file').val('');
        $.ajax({
            type: 'GET', url: endpoint, contentType: 'application/json', dataType: 'json', success: function (data) {
                $(`#${id}`).empty();
                for (let i = 0; i < data.length; i++) {
                    $(`#${id}`).append(`<option value='${data[i].id}'>${data[i].name}</option>`);
                }
                $(`#${id}`).trigger(eventType);
            }, error: function (jqXHR, status, error) {
                console.log(error);
            }
        });
    }

    $.fn.isUpdateCustomerModalValid = function (id) {
        return $(`#name_${id}`).val() !== '' && $(`#dateOfBirth_${id}`).val() !== '' && $(`#gender_${id}`).val() !== '' && $(`#phone_${id}`).val() !== '' && $(`#email_${id}`).val() !== '' && $(`#address_${id}`).val() !== '' && $(`#type_${id}`).val() !== '' && $(`#identityCard_${id}`).val() !== '' && $(`#registerDate_${id}`).val() !== '';
    }

    $.fn.isUpdateExcelCustomerModalValid = function (id) {
        return $(`#name_${id}`).val() !== '' && $(`#dateOfBirth_${id}`).val() !== '' && $(`#gender_${id}`).val() !== '' && $(`#phone_${id}`).val() !== '' && $(`#email_${id}`).val() !== '' && $(`#address_${id}`).val() !== '' && $(`#identityCard_${id}`).val() !== '';
    }

    $.fn.loadCustomerData = function (endpoint) {
        $.ajax({
            type: 'GET', url: endpoint, contentType: 'application/json', dataType: 'json', success: function (data) {
                console.log(data);
                $('#customers').empty();
                if (data.length > 0) {
                    for (let i = 0; i < data.length; i++) {
                        $('#customers').append(`
                        <tr id="row_${data[i].id}">
                            <input type="hidden" class="form-control" id="apartmentRegister_${data[i].id}" value="${data[i].apartmentRegisterId}">
                            <td>${data[i].id}</td>
                            <td>${data[i].name}</td>
                            <td>${data[i].identityCard}</td>
                            <td><input type="radio" class="form-control" name="host" id="host_${data[i].id}"></td>
                            <td><input type="checkbox" class="form-control" name="residentCard" id="residentCard_${data[i].id}"></td>
                            <td><input type="checkbox" class="form-control" name="motorbikeCard" id="motorbikeCard_${data[i].id}"></td>
                            <td><input type="checkbox" class="form-control" name="carCard" id="carCard_${data[i].id}"></td>
                            <td>
                                <a href="#updateCustomerDetailsModel_${data[i].id}" class="edit" data-toggle="modal"><i class="material-icons"
                                                                                                 data-toggle="tooltip"
                                                                                                 title="Edit">&#xE254;</i></a>
                                <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons"
                                                                                                     data-toggle="tooltip"
                                                                                                     title="Delete">&#xE872;</i></a>
                                <a href="#seeCustomerDetailsModel_${data[i].id}" class="detail" data-toggle="modal"><i class="material-icons"
                                                                                                 data-toggle="tooltip"
                                                                                                 title="Detail">&#xe417;</i></a>
                                <!-- See Customer Details Modal HTML -->
                                <div id="seeCustomerDetailsModel_${data[i].id}" class="modal fade see-customer-details">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form>
                                                <div class="modal-header">
                                                    <h4 class="modal-title">Customer Details</h4>
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="form-group">
                                                        <label>Id</label>
                                                        <input type="text" class="form-control" value="${data[i].id}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Name</label>
                                                        <input type="text" class="form-control" value="${data[i].name}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Date Of Birth</label>
                                                        <input type="date" class="form-control" value="${data[i].dateOfBirth}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Gender</label>
                                                        <input type="text" class="form-control" value="${data[i].gender}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Phone</label>
                                                        <input type="tel" class="form-control" value="${data[i].phone}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Email</label>
                                                        <input type="email" class="form-control" value="${data[i].email}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Address</label>
                                                        <textarea class="form-control" disabled>${data[i].address}</textarea>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Type</label>
                                                        <input type="text" class="form-control" value="${data[i].type}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Identity Card</label>
                                                        <input type="text" class="form-control" value="${data[i].identityCard}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Register Date</label>
                                                        <input type="date" class="form-control" value="${data[i].registerDate}" disabled>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <input type="button" class="btn btn-light" data-dismiss="modal" value="Cancel">
                                                    <input type="button" class="btn btn-success" data-dismiss="modal" value="Ok">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!-- Update Customer Details Modal HTML -->
                                <div id="updateCustomerDetailsModel_${data[i].id}" class="modal fade update-customer-details">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form id="form_${data[i].id}">
                                                <div class="modal-header">
                                                    <h4 class="modal-title">Update Customer</h4>
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="alert alert-danger d-none" id="alert_${data[i].id}"></div>
                                                    <div class="form-group">
                                                        <label>Id</label>
                                                        <input type="text" class="form-control" id="id_${data[i].id}" value="${data[i].id}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Name</label>
                                                        <input type="text" class="form-control" id="name_${data[i].id}" value="${data[i].name}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Date Of Birth</label>
                                                        <input type="date" class="form-control" id="dateOfBirth_${data[i].id}" value="${data[i].dateOfBirth}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Gender</label>
                                                        <input type="text" class="form-control" id="gender_${data[i].id}" value="${data[i].gender}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Phone</label>
                                                        <input type="tel" class="form-control" id="phone_${data[i].id}" value="${data[i].phone}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Email</label>
                                                        <input type="email" class="form-control" id="email_${data[i].id}" value="${data[i].email}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Address</label>
                                                        <textarea class="form-control" id="address_${data[i].id}">${data[i].address}</textarea>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Type</label>
                                                        <input type="text" class="form-control" id="type_${data[i].id}" value="${data[i].type}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Identity Card</label>
                                                        <input type="text" class="form-control" id="identityCard_${data[i].id}" value="${data[i].identityCard}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Register Date</label>
                                                        <input type="date" class="form-control" id="registerDate_${data[i].id}" value="${data[i].registerDate}">
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <input type="button" class="btn btn-light" data-dismiss="modal" value="Cancel">
                                                    <input type="button" class="btn btn-success" id="editSubmit_${data[i].id}" value="Update">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>  
                        `);
                        $(`#host_${data[i].id}`).prop('checked', !!data[i].host);
                        $(`#residentCard_${data[i].id}`).prop('checked', !!data[i].residentCard.active);
                        $(`#motorbikeCard_${data[i].id}`).prop('checked', !!data[i].motorbikeCard.active);
                        $(`#carCard_${data[i].id}`).prop('checked', !!data[i].carCard.active);

                        $(`#editSubmit_${data[i].id}`).on('click', function () {
                            let customerUpdate = {};
                            customerUpdate.id = $(`#id_${data[i].id}`).val();
                            customerUpdate.name = $(`#name_${data[i].id}`).val();
                            customerUpdate.dateOfBirth = $(`#dateOfBirth_${data[i].id}`).val();
                            customerUpdate.gender = $(`#gender_${data[i].id}`).val();
                            customerUpdate.phone = $(`#phone_${data[i].id}`).val();
                            customerUpdate.email = $(`#email_${data[i].id}`).val();
                            customerUpdate.address = $(`#address_${data[i].id}`).val();
                            customerUpdate.type = $(`#type_${data[i].id}`).val();
                            customerUpdate.identityCard = $(`#identityCard_${data[i].id}`).val();
                            customerUpdate.registerDate = $(`#registerDate_${data[i].id}`).val();

                            $.ajax({
                                type: 'POST',
                                url: `http://localhost:8081/api/customers/edit`,
                                contentType: 'application/json',
                                dataType: 'json',
                                data: JSON.stringify(customerUpdate),
                                success: function (response) {
                                    if (response.status === 'FAIL') {
                                        $(`#alert_${data[i].id}`).removeClass('d-none')
                                        $(`#alert_${data[i].id}`).empty();
                                        $(`#alert_${data[i].id}`).append(`<ul id="errors_${data[i].id}"></ul>`);
                                        for (let j = 0; j < response.result.length; j++) {
                                            $(`#errors_${data[i].id}`).append(`<li>${response.result[j].defaultMessage}</li>`)
                                        }
                                    } else {
                                        $(`#updateCustomerDetailsModel_${data[i].id}`).modal('hide');
                                        let tds = $(`#row_${data[i].id}`).find('td');
                                        tds.eq(1).html(response.result.name);
                                        tds.eq(2).html(response.result.identityCard);
                                        let detailModal = tds.eq(7).find(`#seeCustomerDetailsModel_${data[i].id}`).eq(0);
                                        let detailInputs = detailModal.find('input');
                                        let detailTextArea = detailModal.find('textarea').eq(0);
                                        detailInputs.eq(1).val(response.result.name);
                                        detailInputs.eq(2).val(response.result.dateOfBirth);
                                        detailInputs.eq(3).val(response.result.gender);
                                        detailInputs.eq(4).val(response.result.phone);
                                        detailInputs.eq(5).val(response.result.email);
                                        detailTextArea.eq(0).val(response.result.address);
                                        detailInputs.eq(6).val(response.result.type);
                                        detailInputs.eq(7).val(response.result.identityCard);
                                        detailInputs.eq(8).val(response.result.registerDate);
                                        let editModal = tds.eq(7).find(`#updateCustomerDetailsModel_${data[i].id}`).eq(0);
                                        let editInputs = editModal.find('input');
                                        let editTextArea = editModal.find('textarea').eq(0);
                                        editInputs.eq(1).val(response.result.name);
                                        editInputs.eq(2).val(response.result.dateOfBirth);
                                        editInputs.eq(3).val(response.result.gender);
                                        editInputs.eq(4).val(response.result.phone);
                                        editInputs.eq(5).val(response.result.email);
                                        editTextArea.eq(0).val(response.result.address);
                                        editInputs.eq(6).val(response.result.type);
                                        editInputs.eq(7).val(response.result.identityCard);
                                        editInputs.eq(8).val(response.result.registerDate);
                                    }
                                },
                                error: function (jqXHR, status, error) {
                                    console.log(error);
                                }
                            });
                        });

                        $(`#updateCustomerDetailsModel_${data[i].id}`).on('hidden.bs.modal', function () {
                            if ($(`#alert_${data[i].id}`).html() !== '' || !$.fn.isUpdateCustomerModalValid(data[i].id)) {
                                $(`#form_${data[i].id}`).trigger('reset');
                            }
                            $(`#alert_${data[i].id}`).empty();
                            $(`#alert_${data[i].id}`).addClass('d-none');
                        });
                    }
                }
            }, error: function (jqXHR, status, error) {
                console.log(error);
            }
        });
    }

    $.fn.loadSelectData(`${endpoint}/projects`, 'project', 'change');
    $('#project').on('change', function () {
        $.fn.loadSelectData(`${endpoint}/buildings/${$(this).val()}`, 'building', 'change');
    });
    $('#building').on('change', function () {
        $.fn.loadSelectData(`${endpoint}/floors/${$(this).val()}`, 'floor', 'change');
        $.fn.loadSelectData(`${endpoint}/parking-areas/${$(this).val()}`, 'parkingArea', 'change');
    });
    $('#floor').on('change', function () {
        $.fn.loadSelectData(`${endpoint}/apartments/${$(this).val()}`, 'apartment', 'change');
    });

    $('#apartment').on('change', function () {
        $('#file').val('');
        $.fn.loadCustomerData(`${endpoint}/apartment_registers/${$(this).val()}`);
    });

    $('#file').on('change', function () {
        const formData = new FormData();
        formData.append('file', $(this)[0].files[0]);
        $.ajax({
            type: 'POST',
            url: `${endpoint}/customers/import-excel`,
            processData: false,
            contentType: false,
            dataType: 'json',
            data: formData,
            success: function (data) {
                console.log(data);
                if (data.length > 0) {
                    for (let i = 0; i < data.length; i++) {
                        $('#customers').append(`
                        <tr id="row_${data[i].id}">
                            <input type="hidden" class="form-control" id="apartmentRegister_${data[i].id}">
                            <td class="text-success">${data[i].id}</td>
                            <td class="text-success">${data[i].name}</td>
                            <td class="text-success">${data[i].identityCard}</td>
                            <td><input type="radio" class="form-control" name="host" id="host_${data[i].id}"></td>
                            <td><input type="checkbox" class="form-control" name="residentCard" id="residentCard_${data[i].id}"></td>
                            <td><input type="checkbox" class="form-control" name="motorbikeCard" id="motorbikeCard_${data[i].id}"></td>
                            <td><input type="checkbox" class="form-control" name="carCard" id="carCard_${data[i].id}"></td>
                            <td>
                                <a href="#updateCustomerDetailsModel_${data[i].id}" class="edit" data-toggle="modal"><i class="material-icons"
                                                                                                 data-toggle="tooltip"
                                                                                                 title="Edit">&#xE254;</i></a>
                                <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons"
                                                                                                     data-toggle="tooltip"
                                                                                                     title="Delete">&#xE872;</i></a>
                                <a href="#seeCustomerDetailsModel_${data[i].id}" class="detail" data-toggle="modal"><i class="material-icons"
                                                                                                 data-toggle="tooltip"
                                                                                                 title="Detail">&#xe417;</i></a>
                                <!-- See Customer Details Modal HTML -->
                                <div id="seeCustomerDetailsModel_${data[i].id}" class="modal fade see-customer-details">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form>
                                                <div class="modal-header">
                                                    <h4 class="modal-title">Customer Details</h4>
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="form-group">
                                                        <label>Id</label>
                                                        <input type="text" class="form-control" value="${data[i].id}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Name</label>
                                                        <input type="text" class="form-control" value="${data[i].name}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Date Of Birth</label>
                                                        <input type="date" class="form-control" value="${data[i].dateOfBirth}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Gender</label>
                                                        <input type="text" class="form-control" value="${data[i].gender}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Phone</label>
                                                        <input type="tel" class="form-control" value="${data[i].phone}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Email</label>
                                                        <input type="email" class="form-control" value="${data[i].email}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Address</label>
                                                        <textarea class="form-control" disabled>${data[i].address}</textarea>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Type</label>
                                                        <input type="text" class="form-control" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Identity Card</label>
                                                        <input type="text" class="form-control" value="${data[i].identityCard}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Register Date</label>
                                                        <input type="date" class="form-control" disabled>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <input type="button" class="btn btn-light" data-dismiss="modal" value="Cancel">
                                                    <input type="button" class="btn btn-success" data-dismiss="modal" value="Ok">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!-- Update Customer Details Modal HTML -->
                                <div id="updateCustomerDetailsModel_${data[i].id}" class="modal fade update-customer-details">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form id="form_${data[i].id}">
                                                <div class="modal-header">
                                                    <h4 class="modal-title">Update Customer</h4>
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="alert alert-danger d-none" id="alert_${data[i].id}"></div>
                                                    <div class="form-group">
                                                        <label>Id</label>
                                                        <input type="text" class="form-control" id="id_${data[i].id}" value="${data[i].id}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Name</label>
                                                        <input type="text" class="form-control" id="name_${data[i].id}" value="${data[i].name}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Date Of Birth</label>
                                                        <input type="date" class="form-control" id="dateOfBirth_${data[i].id}" value="${data[i].dateOfBirth}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Gender</label>
                                                        <input type="text" class="form-control" id="gender_${data[i].id}" value="${data[i].gender}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Phone</label>
                                                        <input type="tel" class="form-control" id="phone_${data[i].id}" value="${data[i].phone}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Email</label>
                                                        <input type="email" class="form-control" id="email_${data[i].id}" value="${data[i].email}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Address</label>
                                                        <textarea class="form-control" id="address_${data[i].id}">${data[i].address}</textarea>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Type</label>
                                                        <input type="text" class="form-control" id="type_${data[i].id}" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Identity Card</label>
                                                        <input type="text" class="form-control" id="identityCard_${data[i].id}" value="${data[i].identityCard}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Register Date</label>
                                                        <input type="date" class="form-control" id="registerDate_${data[i].id}" disabled>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <input type="button" class="btn btn-light" data-dismiss="modal" value="Cancel">
                                                    <input type="button" class="btn btn-success" id="editSubmit_${data[i].id}" value="Update">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>  
                        `);

                        $(`#editSubmit_${data[i].id}`).on('click', function () {
                            let customerUpdate = {};
                            customerUpdate.id = $(`#id_${data[i].id}`).val();
                            customerUpdate.name = $(`#name_${data[i].id}`).val();
                            customerUpdate.dateOfBirth = $(`#dateOfBirth_${data[i].id}`).val();
                            customerUpdate.gender = $(`#gender_${data[i].id}`).val();
                            customerUpdate.phone = $(`#phone_${data[i].id}`).val();
                            customerUpdate.email = $(`#email_${data[i].id}`).val();
                            customerUpdate.address = $(`#address_${data[i].id}`).val();
                            customerUpdate.type = $(`#type_${data[i].id}`).val() === '' ? 'Cư dân' : $(`#type_${data[i].id}`).val();
                            customerUpdate.identityCard = $(`#identityCard_${data[i].id}`).val();
                            customerUpdate.registerDate = $(`#registerDate_${data[i].id}`).val() === '' ? moment().format('YYYY-MM-DD') : $(`#registerDate_${data[i].id}`).val();

                            $.ajax({
                                type: 'POST',
                                url: `http://localhost:8081/api/customers/edit`,
                                contentType: 'application/json',
                                dataType: 'json',
                                data: JSON.stringify(customerUpdate),
                                success: function (response) {
                                    if (response.status === 'FAIL') {
                                        $(`#alert_${data[i].id}`).removeClass('d-none')
                                        $(`#alert_${data[i].id}`).empty();
                                        $(`#alert_${data[i].id}`).append(`<ul id="errors_${data[i].id}"></ul>`);
                                        for (let j = 0; j < response.result.length; j++) {
                                            $(`#errors_${data[i].id}`).append(`<li>${response.result[j].defaultMessage}</li>`)
                                        }
                                    } else {
                                        $(`#updateCustomerDetailsModel_${data[i].id}`).modal('hide');
                                        let tds = $(`#row_${data[i].id}`).find('td');
                                        tds.eq(1).html(response.result.name);
                                        tds.eq(2).html(response.result.identityCard);
                                        let detailModal = tds.eq(7).find(`#seeCustomerDetailsModel_${data[i].id}`).eq(0);
                                        let detailInputs = detailModal.find('input');
                                        let detailTextArea = detailModal.find('textarea').eq(0);
                                        detailInputs.eq(1).val(response.result.name);
                                        detailInputs.eq(2).val(response.result.dateOfBirth);
                                        detailInputs.eq(3).val(response.result.gender);
                                        detailInputs.eq(4).val(response.result.phone);
                                        detailInputs.eq(5).val(response.result.email);
                                        detailTextArea.eq(0).val(response.result.address);
                                        detailInputs.eq(7).val(response.result.identityCard);
                                        let editModal = tds.eq(7).find(`#updateCustomerDetailsModel_${data[i].id}`).eq(0);
                                        let editInputs = editModal.find('input');
                                        let editTextArea = editModal.find('textarea').eq(0);
                                        editInputs.eq(1).val(response.result.name);
                                        editInputs.eq(2).val(response.result.dateOfBirth);
                                        editInputs.eq(3).val(response.result.gender);
                                        editInputs.eq(4).val(response.result.phone);
                                        editInputs.eq(5).val(response.result.email);
                                        editTextArea.eq(0).val(response.result.address);
                                        editInputs.eq(7).val(response.result.identityCard);
                                    }
                                },
                                error: function (jqXHR, status, error) {
                                    console.log(error);
                                }
                            });
                        });

                        $(`#updateCustomerDetailsModel_${data[i].id}`).on('hidden.bs.modal', function () {
                            if ($(`#alert_${data[i].id}`).html() !== '' || !$.fn.isUpdateExcelCustomerModalValid(data[i].id)) {
                                $(`#form_${data[i].id}`).trigger('reset');
                            }
                            $(`#alert_${data[i].id}`).empty();
                            $(`#alert_${data[i].id}`).addClass('d-none');
                        });
                    }
                }
            },
            error: function (jqXHR, status, error) {
                console.log(error);
                $('#errorContent').html('Import Excel Failed!');
                $('#errorModal').modal('show');
            }
        });
    });

    $('#submit').on('click', function () {
        let customerRegisters = [];
        let hostCount = 0;
        $('#customers').find('tr').each(function () {
            let tds = $(this).find('td');
            let modals = tds.eq(7).find('.see-customer-details');
            let inputs = modals.find('input');
            let textAreas = modals.find('textarea');
            let customerRegister = {};
            customerRegister.apartmentRegisterId = $(this).find('input').eq(0).val();
            customerRegister.id = inputs.eq(0).val();
            customerRegister.name = inputs.eq(1).val();
            customerRegister.dateOfBirth = inputs.eq(2).val();
            customerRegister.gender = inputs.eq(3).val();
            customerRegister.phone = inputs.eq(4).val();
            customerRegister.email = inputs.eq(5).val();
            customerRegister.address = textAreas.eq(0).val();
            customerRegister.type = inputs.eq(6).val() === '' ? 'Cư dân' : inputs.eq(6).val();
            customerRegister.identityCard = inputs.eq(7).val();
            customerRegister.registerDate = inputs.eq(8).val() === '' ? moment().format('YYYY-MM-DD') : inputs.eq(8).val();
            customerRegister.host = tds.eq(3).find('input').eq(0).prop('checked');
            customerRegister.residentCard = tds.eq(4).find('input').eq(0).prop('checked');
            customerRegister.motorbikeCard = tds.eq(5).find('input').eq(0).prop('checked');
            customerRegister.carCard = tds.eq(6).find('input').eq(0).prop('checked');
            customerRegister.projectId = $('#project').val();
            customerRegister.buildingId = $('#building').val();
            customerRegister.floorId = $('#floor').val();
            customerRegister.apartmentId = $('#apartment').val();
            customerRegister.parkingAreaId = $('#parkingArea').val();
            hostCount = customerRegister.host ? hostCount + 1 : hostCount;
            customerRegisters.push(customerRegister);
        });
        console.log(customerRegisters);
        if (hostCount === 0) {
            $('#errorContent').html('Host Not Select!');
            $('#errorModal').modal('show');
        } else {
            $.ajax({
                type: 'POST',
                url: `${endpoint}/customers/add`,
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(customerRegisters),
                success: function () {
                    $('#file').val('');
                    $.fn.loadCustomerData(`${endpoint}/apartment_registers/${$("#apartment").val()}`);
                },
                error: function (jqXHR, status, error) {
                    console.log(error);
                    $('#errorContent').html('Register Residents Failed!');
                    $('#errorModal').modal('show');
                }
            });
        }
    });
});