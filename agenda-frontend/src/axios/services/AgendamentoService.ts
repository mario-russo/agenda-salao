import { Agendamento } from "../../domain/Agendamento"
import configAxios from "../configAxios"

export async function createAgendamento(agendamento: Agendamento) {
        await configAxios.post('/agendamento', agendamento)

}

export async function listAllAgendamento(): Promise<Agendamento[]> {
        const resulado = (await configAxios.get<Agendamento[]>('/agendamento')).data
        return resulado
    
}