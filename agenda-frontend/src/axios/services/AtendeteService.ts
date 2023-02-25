import { Atendente } from "../../domain/Atendente";
import configAxios from "../configAxios";


export async function createAtendente(atendente: Atendente) {

    await configAxios.post('/atendente', atendente)

}

export async function listAllAtendente(): Promise<Atendente[]> {
    const resulado = (await configAxios.get<Atendente[]>('/atendente')).data
    return resulado
}