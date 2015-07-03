var objcEditor = CodeMirror.fromTextArea(document.getElementById('editorObjc'), {
    mode: "clike",
    // theme: "monokai",
    lineNumbers: true,
    lineWrapping: true,
    matchBrackets: true,
    styleActiveLine: true
});

var swiftEditor = CodeMirror.fromTextArea(document.getElementById('editorSwift'), {
    mode: "swift",
    // theme: "monokai",
    lineNumbers: true,
    lineWrapping: true,
    matchBrackets: true,
    styleActiveLine: true
});