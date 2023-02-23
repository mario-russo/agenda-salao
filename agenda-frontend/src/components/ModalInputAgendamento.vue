<script setup lang="ts">
import { reactive, ref } from "vue";
import configAxios from "../axios/configAxios";
import { Agendamento } from "../domain/Agendamento"

const ph = ref("");
const dense = ref(true);
const dados = reactive<Agendamento>({ atendente: 'mario', cliente: '', data: '', hora: '', servico: '', endereco: '' });

const emits = defineEmits(["createAgendamento"])

async function createAgendamento() {
  await configAxios.post('/agendamento', dados)
  emits("createAgendamento")
}
</script>

<template>
  <div class="filho">
    <div>
      <div>
        <q-input v-model="dados.cliente" size="lg" class="input" label="Cliente" placeholder="Insira um cliente válido"
          :dense="dense">
          <template v-slot:prepend> <i class="fa-regular fa-user"></i></template></q-input>
      </div>

      <div>
        <q-input v-model="dados.servico" class="input" label="Serviço" placeholder="Insira um Serviço válido"
          :dense="dense">
          <template v-slot:prepend>
            <i class="fa-solid fa-business-time"></i>
          </template>
        </q-input>
      </div>
      <div>
        <q-input v-model="dados.data" class="input" label="Data" placeholder="Digite uma data " :dense="dense">
          <template v-slot:prepend>
            <q-icon name="event" />
          </template>
        </q-input>
      </div>
      <div>
        <q-input v-model="dados.hora" class="input" label="Hora" placeholder="Digite a Hora" :dense="dense">
          <template v-slot:prepend>
            <i class="fa-regular fa-clock"></i>
          </template>
        </q-input>
      </div>
      <div>
        <q-input v-model="dados.endereco" class="input" label="Endereço" placeholder="Digite um  endereço" :dense="dense">
          <template v-slot:prepend>
            <q-icon name="place" />
          </template>
        </q-input>
      </div>
    </div>
    <q-space></q-space>
    <div>
      <q-btn-group spread>
        <q-btn color="purple" label="" icon="cancel" />
        <q-btn color="purple" label="" icon="send" @click="createAgendamento()" />
      </q-btn-group>
    </div>
  </div>
</template>
<style scoped>
.filho {
  width: 90%;
}

.filho div {
  margin-bottom: 20px;
}
</style>
