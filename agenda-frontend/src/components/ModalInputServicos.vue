<script setup lang="ts">
import { reactive, ref } from "vue";
import configAxios from "../axios/configAxios";
import { Servico } from "../domain/Servico";

type agendamento = {
  cliente?: string;
  servico?: string;
  data?: string;
  hora?: string;
  atendente?: string;
  endereco?: string;
};
const ph = ref("");
const dense = ref(true);
const dados = reactive<Servico>({ nome: "", preco: 0 });

function createServicos() {
  configAxios.post("/servico", dados);
}
</script>

<template>
  <div>
    <div>
      <q-input
        v-model="dados.nome"
        size="lg"
        class="input"
        label="Cliente"
        placeholder="Insira um cliente válido"
        :dense="dense"
      >
        <template v-slot:prepend> <i class="fa-regular fa-user"></i></template
      ></q-input>
    </div>

    <div>
      <q-input
        v-model="dados.preco"
        class="input"
        label="Serviço"
        placeholder="Insira um Serviço válido"
        :dense="dense"
      >
        <template v-slot:prepend>
          <i class="fa-solid fa-business-time"></i>
        </template>
      </q-input>
    </div>
    <q-space></q-space>
    <div>
      <q-btn-group spread>
        <q-btn color="purple" label="" icon="cancel" />
        <q-btn
          color="purple"
          label=""
          icon="send"
          @click="createServicos()"
        />
      </q-btn-group>
    </div>
  </div>
  {{ dados }}
</template>
<style scoped>
.filho {
  width: 90%;
}
.filho div {
  margin-bottom: 20px;
}
</style>
