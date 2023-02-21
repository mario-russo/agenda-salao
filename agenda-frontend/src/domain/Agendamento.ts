export class Agendamento{

    cliente: string;
    data: string;
    hora: string;
    servico: string;
    atendente: string;
    endereco: string;

    constructor(cliente:string, data:string,hora:string, servico:string,  atendente:string, endereco:string){
        this.cliente = cliente
        this.data = data
        this.hora = hora
        this.servico= servico
        this.atendente = atendente
        this.endereco = endereco
    }
}
