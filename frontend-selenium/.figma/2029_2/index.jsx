import React from 'react';

import styles from './index.module.scss';

const Component = () => {
  return (
    <div className={styles.sPlash}>
      <div className={styles.bg}>
        <div className={styles.autoWrapper}>
          <div className={styles.ellipse15} />
          <div className={styles.ellipse13} />
          <div className={styles.ellipse14} />
        </div>
        <div className={styles.autoWrapper2}>
          <div className={styles.group287}>
            <div className={styles.ellipse17} />
            <div className={styles.ellipse18} />
          </div>
          <div className={styles.ellipse16} />
        </div>
      </div>
      <div className={styles.iPhoneXStatusBarsSta}>
        <div className={styles.timeStyle}>
          <p className={styles.aTime3}>
            <span className={styles.aTime}>9:4</span>
            <span className={styles.aTime2}>1</span>
          </p>
        </div>
        <img
          src="../image/mhb2ebaj-6hvcxj9.svg"
          className={styles.cellularConnection}
        />
        <img src="../image/mhb2ebai-1rxqxre.svg" className={styles.wifi} />
        <img src="../image/mhb2ebai-7uuws4l.svg" className={styles.battery} />
      </div>
    </div>
  );
}

export default Component;
