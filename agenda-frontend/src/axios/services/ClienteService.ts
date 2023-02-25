import { Cliente } from "../../domain/Cliente"
import configAxios from "../configAxios"

export async function createCliente(cliente: Cliente) {
    await configAxios.post('/cliente', cliente)

}

export async function listAllCliente(): Promise<Cliente[]> {
    let resulado = (await configAxios.get<Cliente[]>('/cliente')).data
    return resulado
}
export async function getIdCliente(id: number): Promise<Cliente> {

    let resultado = (await configAxios.get('/Cliente' + id)).data
    return resultado

}