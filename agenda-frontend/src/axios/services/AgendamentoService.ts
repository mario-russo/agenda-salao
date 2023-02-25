import { Agendamento } from "../../domain/Agendamento"
import configAxios from "../configAxios"

export async function createAgendamento(agendamento: Agendamento) {
    try {
        await configAxios.post('/agendamento', agendamento)

    } catch (error) {
        return error
    }
}

export async function listAllAgendamento(): Promise<Agendamento[]> {
    try {
        const resulado = (await configAxios.get<Agendamento[]>('/agendamento')).data
        return resulado
    } catch (error:any) {
        return error
    }

}