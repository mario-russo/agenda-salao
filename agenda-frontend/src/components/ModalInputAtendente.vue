<script setup lang="ts">
import { reactive, ref } from "vue";
import configAxios from "../axios/configAxios";
import { Atendente } from "../domain/Atendente";


const ph = ref("");
const dense = ref(true);
const dados = reactive<Atendente>({ nome: "", email:'',senha:''});
const emits = defineEmits(["createAtendente"])
function createAtendente() {
  configAxios.post("/atendente", dados);
  emits("createAtendente")
}
</script>

<template>
  <div class="filho">
    <div>
      <div>
        <q-input
          v-model="dados.nome"
          size="lg"
          class="input"
          label="Nome"
          placeholder="Insira um Nome do atendente"
          :dense="dense"
        >
          <template v-slot:prepend> <i class="fa-regular fa-user"></i></template
        ></q-input>
      </div>
  
      <div>
        <q-input
          v-model="dados.email"
          class="input"
          label="email"
          type="email"
          placeholder="Insira um Email do atendente"
          :dense="dense"
        >
          <template v-slot:prepend>
            <i class="fa-solid fa-business-time"></i>
          </template>
        </q-input>
      </div>
      <div>
        <q-input
          v-model="dados.senha"
          class="input"
          label="senha"
          type="password"
          placeholder="Insira uma senha"
          :dense="dense"
        >
          <template v-slot:prepend>
            <i class="fa-solid fa-password-time"></i>
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
            @click="createAtendente()"
          />
        </q-btn-group>
      </div>
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
