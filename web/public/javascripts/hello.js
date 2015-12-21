(function(){

var updateInterval = 800;

var objcEditor = CodeMirror.fromTextArea(document.getElementById('editorObjc'), {
    mode: "text/x-objectivec",
    indentUnit: 4,
    smartIndent: false,
    lineNumbers: true,
    lineWrapping: true,
    matchBrackets: true,
    styleActiveLine: true
});

var swiftEditor = CodeMirror.fromTextArea(document.getElementById('editorSwift'), {
    mode: "swift",
    indentUnit: 4,
    smartIndent: true,
    lineNumbers: true,
    lineWrapping: true,
    matchBrackets: true,
    styleActiveLine: true
});

var execute = function() {
    var value = objcEditor.getDoc().getValue();
    var post = {source: value};
    $.post("/convert", post, function(data) {
        console.log("convert");
        swiftEditor.getDoc().setValue(data);
    });
};

objcEditor.on('change', function() {
  var currentTimer;

  return function(obj, e) {
    if(!$("#auto").is(':checked'))
      return;

    var timer = setTimeout(function() {
      if(currentTimer !== timer)
        return;

      execute();
    }, updateInterval);

    currentTimer = timer;
  }
}());

$("#convertBtn").click(execute);

})();