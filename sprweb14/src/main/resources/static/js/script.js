
// 삭제 확인 (이미 있던 거)
function confirmDelete(num) {
    const deleteLink = document.getElementById('deleteConfirmLink');
    deleteLink.href = "/delete?num=" + num;
    const deleteModal = new bootstrap.Modal(document.getElementById('confirmDeleteModal'));
    deleteModal.show();
}

// 등록 확인
function confirmInsert() {
    const insertModal = new bootstrap.Modal(document.getElementById('confirmInsertModal'));
    insertModal.show();
}
function submitInsertForm() {
    document.getElementById('insertForm').submit();
}

// 수정 확인
function confirmUpdate() {
    const updateModal = new bootstrap.Modal(document.getElementById('confirmUpdateModal'));
    updateModal.show();
}
function submitUpdateForm() {
    document.getElementById('updateForm').submit();
}
