import React from "react";
import { FlatList, StyleSheet, SafeAreaView } from "react-native";
import AthleteItem from "./AthleteItem";

const renderItem = ({ item, index, separators }) => (
	<View key={item.key}>
		<AthleteItem>{item.name}</AthleteItem>
	</View>
);

function AthleteList(props) {
	const { athletes } = props;
	return (
		<SafeAreaView style={styles.container}>
			<FlatList
				data={athletes}
				renderItem={renderItem}
				keyExtractor={(item) => item.id}
			/>
		</SafeAreaView>
	);
}

const styles = StyleSheet.create({
	container: {
		flex: 1,
	},
});

export default AthleteList;
