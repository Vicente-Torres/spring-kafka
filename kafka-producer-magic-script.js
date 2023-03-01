/*// Automation script example:

Magic.reportProgress('Started: ' + new Date());

var topic = Magic.createTopic('My cluster name', 'my_new_topic_name');
topic.publishMessage({ "myField1": "bar", "myField2": 3 });

var messages = topic.search(false, 10, function (context) {
    return context.Message.myField1 == 'bar';
});

topic.delete();

Magic.reportProgress('Done: ' + new Date());
return messages;

*/
var topic = Magic.getTopic("kafka", "example");
var qtd = 10;
var count = 0;
var equipmentInfo = {}
while(count<qtd){
    equipmentInfo.codigoEquipamento = "S023467";
    equipmentInfo.temperaturaHD = 45.4;
    equipmentInfo.usoRAM = 20;
    equipmentInfo.dataLeitura = new Date().toISOString();
    topic.publishMessage(equipmentInfo);
    count++;
}

return 'Done!';