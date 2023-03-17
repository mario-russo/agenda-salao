<script lang="ts" setup>
import { reactive, ref } from 'vue';

const user = reactive({
    email: '',
    senha: ''
})
const cadastroUser = reactive({
    nome: '',
    email: '',
    senha: '',

})
const cadastro = ref(true)
const senha = ref('')
</script>
<template>
    <section>
        <form v-if="cadastro">
            <h4>Login</h4>
            <q-input type="email" class="input" outlined v-model="user.email" label="E-mail" :dense="true" />
            <q-input type="password" class="input" outlined v-model="user.senha" label="Senha" :dense="true" />
            <q-btn class="btn" outline style="color: goldenrod;" label="Entrar" type="submit" />
            <p class="login-texto" v-if="cadastro" @click="cadastro = !cadastro">Não tem login? <b>Crie uma conta </b></p>
        </form>

        <form v-else>
            <h4>Cadastro</h4>
            <q-input type="email" class="input" outlined v-model="cadastroUser.nome" label="Digite o Nome" :dense="true" />
            <q-input type="email" class="input" outlined v-model="cadastroUser.email" label="Digite o E-mail"
                :dense="true" />
            <!-- <q-input type="password" class="input" outlined v-model="cadastroUser.senha" label="Digite uma Senha" /> -->
            <q-input type="text" class="input" outlined v-model="cadastroUser.senha" label="Digite sua Senha"
                :dense="true" />
            <q-input type="text" class="input" outlined v-model="senha" label="Confime uma Senha" :dense="true" />
            <q-btn class="btn" outline style="color:rgba(0, 212, 255, 1);" label="Entrar" type="submit" />
            <p class="login-texto" @click="cadastro = !cadastro"><b>Volta ao login</b></p>
        </form>

    </section>
</template>
<style scoped>
section {
    background-color: crimson;
    background: linear-gradient(90deg, rgba(2, 0, 36, 1) 13%, rgba(121, 9, 62, 1) 41%, rgba(0, 212, 255, 1) 97%);
    height: 100vh;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
}

form {
    background-color: white;
    border-radius: 8px;
    width: 500px;
    height: auto;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: 10px;
    box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}



form .input {
    margin-bottom: 30px;
    width: 100%;
}

form .btn {
    margin-bottom: 30px;
    width: 100%;
}



.login-texto {
    cursor: pointer;
}
</style>