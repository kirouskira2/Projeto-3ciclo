import React from 'react';

import styles from './index.module.scss';

const Component = () => {
  return (
    <div className={styles.rectangle3}>
      <p className={styles.findPerfectPlaceForY3}>
        <span className={styles.findPerfectPlaceForY}>
          Encontre o lugar
          <br />
        </span>
        <span className={styles.findPerfectPlaceForY2}>dos seus sonhos!</span>
      </p>
      <div className={styles.group2}>
        <p className={styles.signUp}>Registrar</p>
      </div>
      <p className={styles.alreadyHaveAnAccount3}>
        <span className={styles.alreadyHaveAnAccount}>
          Já possui uma conta?&nbsp;
        </span>
        <span className={styles.alreadyHaveAnAccount2}>Logue aqui!</span>
      </p>
    </div>
  );
}

export default Component;
