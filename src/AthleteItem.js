import React from 'react';

function AthleteItem(props) {
	const { children, ...rest } = props;
	return <Text {...rest}>{name}</Text>
}

export default AthleteItem;